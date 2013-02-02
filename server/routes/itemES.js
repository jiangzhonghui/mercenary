var SongQuery = require('../db/queries/SongQuery');


module.exports = function(app, db, request, logger) {

	var buildFltClause = function(queryName, queryParam){
        var fltClause={
            "flt" : {
                "fields" : [queryName],
                "like_text" : queryParam,
                "max_query_terms" : 12
            }
        }
        return fltClause;
    };

	app.get('/song', function(req, res) {
		var search = [],
			page = req.query['page'],
			results_per_page = req.query['results_per_page'];

        logger.debug('New search with params : ');
        var fltclauses = []
        _.each(req.query, function(queryParam, queryName) {
            if(queryName === 'page' || queryName === 'results_per_page') return;
			if(queryParam==='') return;
            logger.debug(queryName + ' fuzzy like "' + queryParam + '"');

            fltclauses.push(buildFltClause(queryName, queryParam));
		});


        var requestBody = {};
        if (page && results_per_page) {
            requestBody["from"] = (page)*results_per_page;
            requestBody["size"] = results_per_page;
        }

        //requestBody["sort"] = {"id":"asc"};

        if(fltclauses.length>0){
             requestBody["query"]={
                "bool" : {
                    "must" : fltclauses
                }
            }
        }

        logger.debug(requestBody)
        request.post({url: 'http://localhost:9200/mongoidx/_search', body: requestBody}, function(err, response, body) {
            var  items = []
            for (var i=0;i<body.hits.hits.length;i++) {
                items.push(body.hits.hits[i]._source);
            }
            res.send({
                page: page,
                results_per_page: results_per_page,
                results: items
            });
        });

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