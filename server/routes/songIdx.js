var SongQuery = require('../db/queries/SongQuery')
    request = require('request').defaults({json: true})


module.exports = function(app, request, logger) {

    var IDX_SEARCH_URL =  "http://localhost:9200/mongoidx/_search";

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

	app.get('/songIdx', function(req, res) {
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

        // if you need to sort data, uncomment the following line at your own risks.
        //requestBody["sort"] = {"id":"asc"};

        if(fltclauses.length>0){
             requestBody["query"]={
                "bool" : {
                    "must" : fltclauses
                }
            }
        }

        logger.debug(requestBody)
        request.post({url: IDX_SEARCH_URL, body: requestBody}, function(err, response, body) {
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

};