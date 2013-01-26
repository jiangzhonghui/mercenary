var express = require('express'),
	app = express(),
	db = require('mongojs').connect('mercenary', ['items']),
	_ = require('underscore');

app.use(express.bodyParser());
app.use(express.static(__dirname + '/../webapp'));

require('./routes/item')(app, db, _);

app.listen(3000);