const swaggerAutogen = require('swagger-autogen')();

const doc = {
  info: {
    title: 'Puppeteer Executor',
    description: 'Serviço Web - API Rest - Extração de informação utilizando o puppeteer.',
  },
  basePath: '/api/v1',  
  host: ['puppeteer-executor.achimid.com.br'],
  schemes: ['https'],
};

const outputFile = './swagger-output.json';
const endpointsFiles = ['./src/utils/routes.js'];

swaggerAutogen(outputFile, endpointsFiles, doc);