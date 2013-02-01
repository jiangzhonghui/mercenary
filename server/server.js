var express = require('express'),
    logger = require('./graffiti.js'),
    app = express(),
    // uncomment the following when using with ES
    //http = require('http'),
    db = require('mongojs').connect('mercenary', ['items']),
    request = require('request').defaults({
        json: true
    }),
    _ = require('underscore');

app.use(express.bodyParser());
app.use(express.static(__dirname + '/../webapp'));
app.use(express.favicon());
app.use(logger.express(express));

require('./routes/item')(app, db, _, logger);
require('./routes/node')(app, db, request, _, logger);

// uncomment for using ES
//require('./routes/itemES')(app, db, _, http);

app.listen(3000);
logger.info("Server is listening for connections on port 3000...");

