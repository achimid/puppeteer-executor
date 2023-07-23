const swaggerAutogen = require('swagger-autogen')();

const doc = {
  info: {
    title: 'Puppeteer Executor',
    description: 'Serviço Web - API Rest - Extração de informação utilizando o puppeteer.',
  },
  basePath: '/api/v1',  
  host: ['localhost:3000'],
  schemes: ['http'],
};

const outputFile = './swagger-output.json';
const endpointsFiles = ['./src/utils/routes.js'];

swaggerAutogen(outputFile, endpointsFiles, doc);