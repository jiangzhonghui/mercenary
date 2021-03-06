var SongQuery = require('../db/queries/SongQuery');
var User = require('./user.js');

module.exports = function (app, logger) {

    app.get('/song', function (req, res) {
        var search = {},
            page = req.query['page'],
            results_per_page = req.query['results_per_page'];

        _.each(req.query, function (queryParam, queryName) {
            if (queryName === 'page' || queryName === 'results_per_page') return;
            search[queryName] = new RegExp(queryParam, 'i');
            logger.debug('you search with args %s : %s', queryName, search[queryName]);
        });


        if (page && results_per_page) {
            SongQuery.pagination(search, page, results_per_page, function (songs) {
                res.send({
                    page: page,
                    results_per_page: results_per_page,
                    results: songs
                });
            });
        } else {
            SongQuery.findAll(search, function (songs) {
                res.send(songs);
            });
        }
    });

    app.post('/song', function (req, res) {
        SongQuery.save(req.body, function (song) {
            res.send(song);
        });
    });

    app.get('/song/:id', function (req, res) {
        SongQuery.findOne(req.param('id'), function (song) {
            res.send(song);
        });
    });


    app.put('/song/:id', function (req, res) {
        SongQuery.update(req.body, function (song) {
            res.send(song);
        });
    });

    app.delete('/song/:id', function (req, res) {
        var user = User.get(req);
        if (user) {
            SongQuery.remove(req.param('id'), function (song) {
                res.send(song);
            });
        } else {
            res.send({}, 401);
        }
    });

    app.get('/song/field/:field/:id', function (req, res) {
        SongQuery.findField(req.param('field'), req.param('id'), function (field) {
            res.send(field);
        })
    });
};