module.exports = function(app, db) {
	app.post('/item', function(req, res) {
		db.items.save(req.body, function(err, item) {
			res.send(item, 201);
		});
	});

	app.get('/item', function(req, res) {
		db.items.find({}, function(err, items) {
			res.send(items);
		});
	});

	app.get('/item/:id', function(req, res) {
		db.items.findOne({_id: db.ObjectId(req.params.id)}, function(err, item) {
			res.send(item);
		});
	});

	app.put('/item/:id', function(req, res) {
		db.items.update({_id: db.ObjectId(req.params.id)}, {$set: req.body}, function(err, item) {
			res.send(item);
		});
	});

	app.delete('/item/:id', function(req, res) {
		db.items.remove({_id: db.ObjectId(req.params.id)}, function(err, item) {
			res.send();
		});
	});
};