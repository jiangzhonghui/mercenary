var mongoose = require('mongoose');

module.exports = function (logger, config) {
    mongoose.connect(config.mongoURI);
    mongoose.set('debug', config.name === 'dev');

    var db = mongoose.connection;

    db.on('error',
        function callback() {
            logger.error("Unable to connect to mongoDB %s", config.mongoURI);
            logger.info('Server is connected to %s', config.mongoURI);
        });
    db.once('open', function callback() {
        logger.info('Server is connected to %s', config.mongoURI);
    });
};