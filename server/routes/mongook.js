var mongoose = require('mongoose');

module.exports = function (logger) {
    var dbURL = 'mongodb://localhost/mercenary';
    mongoose.connect(dbURL);
    mongoose.set('debug', true);

    var db = mongoose.connection;

    db.on('error', console.error.bind(console, 'connection error:'));
    db.once('open', function callback() {
        logger.info('connected to mongodb !');
    });
};