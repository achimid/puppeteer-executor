require('dotenv').config()

const cors = require('cors')
const express = require('express')
const swaggerUi = require('swagger-ui-express')

const app = express()
const router = require('./utils/routes')

app.use(cors())
app.use(express.json())
app.disable('x-powered-by')

router(app)

app.use('/', swaggerUi.serve, swaggerUi.setup(require('../swagger-output.json')))
app.listen(process.env.PORT || 3000)
