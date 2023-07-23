const healthcheck = require('./healthcheck')
const execution = require('../execution/execution-controller')

const { errorHandler } = require('./error-handler')

const prefix = process.env.API_PREFIX + process.env.API_VERSION

module.exports = (app) => {
    console.info(`Registrando rotas...`)

    app.use(errorHandler)

    app.use(`${prefix}`, healthcheck)
    app.use(`${prefix}/execution`, execution)

    console.info(`Rotas registradas com sucesso...`)

    return app
}