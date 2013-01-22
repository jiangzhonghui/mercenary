var express = require('express')
  , app = express()
  , db = require('mongojs').connect('mercenary', ['items']);

app.use(express.bodyParser());
app.use(express.static(__dirname));

require('./routes/item')(app, db);

app.listen(3000);