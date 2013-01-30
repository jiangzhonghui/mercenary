var express = require('express'),
	app = express(),
    http = require('http'),
	db = require('mongojs').connect('mercenary', ['items']),
	_ = require('underscore');

app.use(express.bodyParser());
app.use(express.static(__dirname + '/../webapp'));

require('./routes/item')(app, db, _, http);

app.listen(3000);