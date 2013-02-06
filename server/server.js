global._ = _ = require('underscore');

var express = require('express'),
    app = express(),
    config = require('./config.js')(process.env.NODE_ENV),
    logger = require('graffiti')(config.log),
    mongojs = require('mongojs'),
	db = mongojs(config.mongoURI, ['users']);

app.use(express.bodyParser());
app.use(express.cookieParser());
app.use(express.static(__dirname + '/../webapp'));
app.use(express.favicon());
app.use(logger.express(express));

require('./routes/mongook')(logger, config);
require('./routes/login')(app, db, logger);
require('./routes/songIdx')(app, logger);
require('./routes/song')(app, logger);

app.listen(3000);
logger.info("Server is listening for HTTP requests on port 3000...");