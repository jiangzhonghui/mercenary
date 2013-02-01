var SongQuery = require('../db/queries/SongQuery');


module.exports = function (app, logger) {

    app.get('/song', function (req, res) {
        var search = {},
            page = req.query['page'],
            results_per_page = req.query['results_per_page'];

        console.log(page, results_per_page);

        _.each(req.query, function (queryParam, queryName) {
            if (queryName === 'page' || queryName === 'results_per_page') return;
            search[queryName] = new RegExp(queryParam, 'i');
        });

        if (page && results_per_page) {
            SongQuery.pagination(search, page, results_per_page, function (songs) {
                res.send({
                    page: page,
                    results_per_page: results_per_page,
                    results: songs
                });
                return;
            });
        } else {
            SongQuery.findAll(search, function (songs) {
                res.send(songs);
            })
        }
    });

    app.post('/song', function (req, res) {
        SongQuery.save(req.body, function (song) {
            res.send(song);
        })
    });

    app.get('/song/:id', function (req, res) {
        SongQuery.findOne(req.param('id'), function (song) {
            res.send(song);
        });
    });


    app.put('/song/:id', function (req, res) {
        SongQuery.update(req.body, function (song) {
            res.send(song);
        })
    });

    app.delete('/song/:id', function (req, res) {
        SongQuery.remove(req.param('id'), function (song) {
            res.send(song);
        })
    });
};