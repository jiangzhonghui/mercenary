global._ = _ = require('underscore');

var express = require('express'),
    logger = require('graffiti'),
    app = express();

app.use(express.bodyParser());
app.use(express.cookieParser());
app.use(express.static(__dirname + '/../webapp'));
app.use(express.favicon());
app.use(logger.express(express));

require('./routes/mongook')();
require('./routes/login')(app, logger);
require('./routes/songIdx')(app, logger);
require('./routes/song')(app, logger);

app.listen(3000);
logger.info("Server is listening for connections on port 3000...");