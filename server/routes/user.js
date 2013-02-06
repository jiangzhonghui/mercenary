var request = require('request').defaults({json: true});

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
			else {
                geocode(req.body.city, function (location) {
                    var body = req.body;
                    body.loc = location;
                    db.users.save(req.body, {safe: true}, function () {
                        res.cookie('rememberme', req.body, { maxAge: 900000000000, httpOnly: false });
                        res.send(req.body, 201);
                    });
                });
			}			
		});
	};

    var geocode = function (city, whenGeolocated) {
        request('http://maps.googleapis.com/maps/api/geocode/json?address=' + city + '&sensor=true', function (err, res, body) {
            var loc = {lat: 48.8566140, lng: 2.35222190};//default Paris
            if (body && body.results.length !== 0) {
                loc = body.results[0].geometry.location;
            }

            whenGeolocated({latitude: loc.lat, longitude: loc.lng});
        });
    };

	var connectToAccount = function(req, res) {
		db.users.findOne({mail: req.body.mail}, function(err, user) {
			if(!user)
				unauthorized(res);
			else {
				res.cookie('rememberme', user, { maxAge: 900000000000, httpOnly: false });
				res.send(user);
			}
		});
	};

	app.put('/user', function(req, res) {
		if(!authenticated(req))
			unauthorized(res);
		else {
			var mail = req.body.mail,
				artists = req.body.artists;

			db.users.findOne({mail: mail}, function(err, user) {
				if(!user)
					unauthorized(res);
				else {
					db.users.update({mail: mail}, {$set: {artists: artists}}, {safe: true}, function() {
						user.artists = artists;
						res.send(user);
					});

                    var alreadySavedIds = user.artists.map(function (artist) {
                        return artist.artist_id
                    });
                    var diff = _.filter(artists, function (artist) {
                        return !_.contains(alreadySavedIds, artist.artist_id);
                    });
                    db.timeline.save({username: mail, artist: diff, type: 'like'}, {safe: true}, function () {
                    });
                }
			});
		}	
	});

	app.delete('/user', function(req, res) {
		res.clearCookie('rememberme');
		res.send({});
	});

	app.get('/user', function(req, res){
		if(!authenticated(req))
			unauthorized(res);
		else {
			db.users.findOne({mail: req.cookies.rememberme.mail}, function(err, user) {
				res.send(user);
			});
		}
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