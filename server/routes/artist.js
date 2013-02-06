var ArtistQuery = require('../db/queries/ArtistQuery');
var User = require('./user.js');

module.exports = function (app, logger) {

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
            res.send(artist);
        });
    });


    app.get('/artist/field/:field/:id', function (req, res) {
        ArtistQuery.findField(req.param('field'), req.param('id'), function (field) {
            res.send(field);
        })
    });
};