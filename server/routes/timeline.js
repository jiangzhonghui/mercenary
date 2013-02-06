module.exports = function(app, db, logger) {

	app.get('/timeline', function(req, res) {
		db.timeline.find().sort({_id: -1}).limit(15, function(err, timeline) {
			res.send(timeline);
		});
	});
};