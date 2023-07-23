const router = require('express').Router()
const { CREATED } = require('http-status-codes').StatusCodes

const uuid = require('uuid')

const { sendToQueue, consumeFromQueue } = require('../utils/queue')

router.post('/', (req, res) => {
    // #swagger.tags = ['Execution']
	// #swagger.summary = 'Criar uma execução'    
    /* #swagger.parameters['obj'] = {
            in: 'body',
            description: 'Some description...',
            schema: {
                url: 'https://anifan.com.br/',
                script: 'JSON.stringify({url: document.querySelector(\'a\').href})',
                callbackUrl: 'https://puppeteer-executor.achimid.com.br/api/v1',
                "ref": '123456',
                "config": {
                    "bypassCSP": true,
                    "useRandomAgent": false, 
                    "urlProxy": 'https://proxy.com',
                    "skipImage": false,
                    "logConsole": false,
                    "defaultNavigationTimeout": 3000,        
                    "addScriptTagUrl": 'https://scripturl.com.br',
                    "waitTime": 1000
                }
            }
    } */    
    
    const request = {id: uuid.v4(), ...req.body}
    collection[request.id] = request

    sendToQueue('WORKER_EXECUTION_REQUEST', request)

    return res.status(CREATED).send(request)
})

router.get('/:id', async (req, res) => {
    // #swagger.tags = ['Execution']
	// #swagger.summary = 'Criar uma execução'    
    // #swagger.parameters['id'] = { description: 'Identificado(Id) da execução criada' }

    const execution = collection[req.params.id]

    res.send(execution)

    delete collection[req.params.id]
})


const collection = {}

consumeFromQueue('WORKER_EXECUTION_RESPONSE', (data, ack) => {
    let content = data.content.toString()
    let execution = JSON.parse(content)
    
    collection[execution.request.id] = execution
    
    ack()
})

module.exports = router