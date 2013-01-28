module.exports = function(app, db, request, _) {

	app.post('/node/static', function(req, res) {
		request.post({url: 'http://localhost:3000/node', body: {name: 'paul'}});
		request.post({url: 'http://localhost:3000/node', body: {name: 'john'}});
		request.post({url: 'http://localhost:3000/node', body: {name: 'ringo'}});
		request.post({url: 'http://localhost:3000/node/0/rel', body: {to: 1}});
		request.post({url: 'http://localhost:3000/node/1/rel', body: {to: 2}});
		res.send();
	});

	app.get('/node', function(req, res) {
		request.post({url: url + '/cypher', body: {query: 'start n=node(*) return n'}}, function(err, response, body) {
			res.send(body);
		});
	});

	app.get('/node/:id', function(req, res) {
		request.get(nodeUrl + req.params.id, function(err, response) {
			res.send(response.body.data);
		});
	});

	app.post('/node', function(req, res) {
		request.post({url: url + '/node', body: req.body}, function(err, response) {
			res.send(response.body.data, 201);
		});
	});

	app.get('/node/:id/rel', function(req, res) {
		request.get(nodeUrl + req.params.id + '/relationships/all/follows', function(err, response) {
			res.send(response.body.map(function(node) {
				return resolveRel(node);
			}));
		});
	});

	app.post('/node/:id/rel', function(req, res) {
		request.post({url: nodeUrl + req.params.id + '/relationships', body: {to: nodeUrl + req.body.to, type: 'follows'}}, function(err, response, body) {
			res.send(resolveRel(body));
		});
	});

	app.delete('/node/:id', function(req, res) {
		request.del(nodeUrl + req.params.id, function(err, response) {
			res.send({});
		});
	});

	app.delete('/node/:id/rel', function(req, res) {
		request.get(nodeUrl + req.params.id + '/relationships/all/follows', function(err, response) {
			response.body.map(function(rel) {
				request.del(rel.self);
			});
			res.send({});
		});
	});

	var url = 'http://localhost:7474/db/data';
	var nodeUrl = url + '/node/';
	var resolveRel = function(node) {
		return resolveId(node.start) + '-' + node.type + '->' + resolveId(node.end);
	};
	var resolveId = function(url) {
		return url.substring(url.lastIndexOf('/')+1);
	};
};