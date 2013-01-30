module.exports = function(app, db, _, http) {
	var DEFAULT_PAGE = 1,
		DEFAULT_RESULTS_PER_PAGE = 15;

	app.post('/item', function(req, res) {
		db.items.save(req.body, function(err, item) {
			res.send(item, 201);
		});
	});

	app.get('/item', function(req, res) {
		var search = [],
			page = req.query['page'] || DEFAULT_PAGE,
			results_per_page = req.query['results_per_page'] || DEFAULT_RESULTS_PER_PAGE;

		console.log('\nNew search with params : ');
		_.each(req.query, function(queryParam, queryName) {
			console.log('- ' + queryName + ' like "' + queryParam + '"');
			if(queryName === 'page' || queryName === 'results_per_page') return;
			if(queryParam==='') return;
            search.push(queryName+":"+queryParam);
		});

        var pathParam = "/mongoidx/_search?from="+ (page-1)*results_per_page +"&size="+ results_per_page
        for(var i=0; i<search.length; i++){
            if(i==0){
                pathParam = pathParam + "&q="+search[i];
            }else {
                pathParam = pathParam + "%20AND%20"+search[i];
            }

        }
        console.log(pathParam)
        var requestOptions = {
            host:"localhost",
            port:"9200",
            path:pathParam,
            method: 'GET'
        }

        var request  = http.request(requestOptions, function(response) {
            response.on('data', function(data) {
                var jsonData =  JSON.parse(data)
                var  items = []
                for (var i=0;i<jsonData.hits.hits.length;i++) {
                    items.push(jsonData.hits.hits[i]._source);
                }
                res.send({
                    page: page,
                    results_per_page: results_per_page,
                    results: items
                });
            });
        }).on('error', function(e) {
                console.log("Got error: " + e.message);
        });


        request.end();

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