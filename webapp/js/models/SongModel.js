define(function () {
    return Backbone.Model.extend({
        idAttribute: '_id',
        urlRoot: 'song',
        forTemplate: function () {
            var json = this.toJSON();
            json.duration = this.getDurationString(json.duration.toFixed(0));
            if (json.year === 0) delete json.year;
            return json;
        },
        getDurationString: function (duration) {
            var mind = duration % (60 * 60);
            var minutes = Math.floor(mind / 60);

            var secd = mind % 60;
            var seconds = Math.ceil(secd);

            return minutes + ' min ' + seconds + ' s'
        }
    });
});