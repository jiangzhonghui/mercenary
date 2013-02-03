module.exports = function(app) {
	app.post('/login', function(req, res) {
		res.cookie('rememberme', req.param('name'), { maxAge: 900000, httpOnly: true });
		res.send({});
	});

	app.delete('/login', function(req, res) {
		res.clearCookie('rememberme');
		res.send({});
	});

	app.get('/login', function(req, res){
		if(req.cookies && req.cookies.rememberme)
			res.send({name: req.cookies.rememberme});
		else {
			res.statusCode = 401;
			res.send();
		}
	});
};

module.exports.isLogged = function(req) {
	return req.cookies && req.cookies.rememberme;
};