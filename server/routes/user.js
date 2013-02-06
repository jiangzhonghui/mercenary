module.exports = function(app, db, logger) {

	app.post('/user', function(req, res) {
		if(req.body.city && req.body.username)
			createAccount(req, res);
		else
			connectToAccount(req, res);
	});

	var createAccount = function(req, res) {
		db.users.findOne({mail: req.body.mail}, function(err, user) {
			if(user)
				unauthorized(res);

			db.users.save(req.body, function() {
				res.cookie('rememberme', req.body, { maxAge: 900000, httpOnly: false });
				res.send(req.body, 201);
			});			
		});
	};

	var connectToAccount = function(req, res) {
		db.users.findOne({mail: req.body.mail}, function(err, user) {
			if(!user)
				unauthorized(res);

			res.cookie('rememberme', user, { maxAge: 900000, httpOnly: false });
			res.send(user);
		});
	};

	app.put('/user', function(req, res) {
		if(!authenticated(req))
			unauthorized(res);

		db.users.findOne({mail: req.body.mail}, function(err, user) {
			if(!user)
				unauthorized(res);

			db.users.update({mail: req.body.mail}, {$set: {artists: req.body.artists}}, {safe: true}, function() {
				user.artists = req.body.artists;
				res.send(user);
			});
		});	
	});

	app.delete('/user', function(req, res) {
		res.clearCookie('rememberme');
		res.send({});
	});

	app.get('/user', function(req, res){
		if(!authenticated(req))
			unauthorized(res);
		
		res.send(req.cookies.rememberme);
	});

	var unauthorized = function(res) {
		res.statusCode = 401;
		res.send();
	};

	var authenticated = function(req) {
		return req.cookies && req.cookies.rememberme;
	}
};

module.exports.get = function(req) {
	if(req.cookies && req.cookies.rememberme)
		return req.cookies.rememberme;
	else 
		return undefined;
}