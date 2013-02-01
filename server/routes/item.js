module.exports = function (app, db, _, log) {
    var DEFAULT_PAGE = 1,
        DEFAULT_RESULTS_PER_PAGE = 15;

    app.post('/item', function(req, res) {
        db.items.save(req.body, function(err, item) {
            res.send(item, 201);
        });
    });

    app.get('/item', function(req, res) {
        var search = {},
            page = req.query['page'] || DEFAULT_PAGE,
            results_per_page = req.query['results_per_page'] || DEFAULT_RESULTS_PER_PAGE;

        _.each(req.query, function(queryParam, queryName) {
            if(queryName === 'page' || queryName === 'results_per_page') return;
            search[queryName] = new RegExp(queryParam, 'i');
        });

        db.items.find(search).sort({title: 1}).skip((page-1)*results_per_page).limit(results_per_page, function(err, items) {
            res.send({
                page: page,
                results_per_page: results_per_page,
                results: items
            });
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