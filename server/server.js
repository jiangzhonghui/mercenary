var express = require('express'),
    app = express(),
    db = require('mongojs').connect('mercenary', ['items']),
    request = require('request').defaults({json: true}),
    _ = require('underscore');

app.use(express.bodyParser());
app.use(express.static(__dirname + '/../webapp'));
app.use(express.favicon());
app.use(express.logger('dev'));

require('./routes/item')(app, db, _);
require('./routes/node')(app, db, request, _);

app.listen(3000);
console.log("Server is listening for connections on port 3000...");