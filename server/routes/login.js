module.exports = function(app) {
	app.post('/login', function(req, res) {
		res.cookie('rememberme', true, { maxAge: 900000, httpOnly: true });
		res.send({});
	});

	app.delete('/login', function(req, res) {
		res.clearCookie('rememberme');
		res.send({});
	});

	app.get('/login', function(req, res){
		var rememberme;
		if(req.cookies)
			rememberme = req.cookies.rememberme;
    	res.send('remember: ' + rememberme);
	});
};

module.exports.isLogged = function(req) {
	return req.cookies && req.cookies.rememberme;
};