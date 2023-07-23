const router = require('express').Router()

router.get('/health', async (req, res) => { 
    // #swagger.ignore = true
    return res.json({status: 'ok'}) 
})

module.exports = router