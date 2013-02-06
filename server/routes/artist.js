var ArtistQuery = require('../db/queries/ArtistQuery');
var User = require('./user.js');
var Request = require('request').defaults({json: true})
var XmlParser = require('xml2js').parseString;

module.exports = function (app, db, logger) {

    app.get('/artist', function (req, res) {
        var search = {},
            page = req.query['page'],
            results_per_page = req.query['results_per_page'];

        _.each(req.query, function (queryParam, queryName) {
            if (queryName === 'page' || queryName === 'results_per_page') return;
            search[queryName] = new RegExp(queryParam, 'i');
            logger.debug('you search with args %s : %s', queryName, search[queryName]);
        });


        if (page && results_per_page) {
            ArtistQuery.pagination(search, page, results_per_page, function (artists) {
                _.each(artists, function(artist) {
                     var i = Math.floor(Math.random() * 500) + 100;
                     artist.image = "http://cdn.7static.com/static/img/artistimages/00/000/000/0000000" + i + "_50.jpg";
                })
                res.send({
                    page: page,
                    results_per_page: results_per_page,
                    results: artists
                });
            });
        } else {
            ArtistQuery.findAll(search, function (artists) {
                res.send(artists);                
            });
        }
    });



    app.get('/artist/:id', function (req, res) {
        ArtistQuery.findOne(req.param('id'), function (artist) {
            artist.image = "toto";
            url = "http://api.7digital.com/1.2/artist/details?artistId=" + artist.artist_7digitalid + "&imageSize=50&oauth_consumer_key=7dqm93aabzws";
            request(url, function (error, response, body) {
              if (!error && response.statusCode == 200) {
                XmlParser(body, function(error, result){
                    if(result.response.artist.length > 0) {
                        artist.image = result.response.artist[0].image;
                    }
                    res.send(artist);
                });
              } else {
                console.log("ERROR STATUS " + response);
                res.send(artist);
              }
            })
        });
    });


    app.get('/artist/field/:field/:id', function (req, res) {
        ArtistQuery.findField(req.param('field'), req.param('id'), function (field) {
            res.send(field);
        })
    });
    app.get('/artist/users/:id', function (req, res) {
        var artistId = req.param('id');
        db.users.find({ 'artists.artist_id' : { $in : [ ""+artistId] }}, function (err, users) {
            if(!err){
                res.send(users);
            } else {
                logger.error(err);
            }

        });
    });
};