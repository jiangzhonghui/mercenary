global._ = _ = require('underscore');

var express = require('express'),
    logger = require('graffiti'),
    app = express(),
// uncomment the following when using with ES
//http = require('http'),
    request = require('request').defaults({
        json: true
    }),
    request = require('request').defaults({json: true}),
    mongoose = require('mongoose');

var dbURL = 'mongodb://localhost/mercenary';
mongoose.connect(dbURL);
mongoose.set('debug', true);

var db = mongoose.connection;

db.on('error', console.error.bind(console, 'connection error:'));
db.once('open', function callback() {
    console.log('connected to mongodb !');
});

app.use(express.bodyParser());
app.use(express.static(__dirname + '/../webapp'));
app.use(express.favicon());
app.use(logger.express(express));

// uncomment for using ES
//require('./routes/itemES')(app, db, _, http);
require('./routes/song')(app, logger);
require('./routes/node')(app, request, logger);

app.listen(3000);
logger.info("Server is listening for connections on port 3000...");

