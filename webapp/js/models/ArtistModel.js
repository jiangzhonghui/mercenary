define(function () {
    return Backbone.Model.extend({
        defaults: {
        },
        idAttribute: '_id',
        urlRoot: 'artist',
        initialize: function () {
        },
        forTemplate: function () {
            var json = this.toJSON();
            if (json.year === 0) delete json.year;
            return json;
        }
    });
});
