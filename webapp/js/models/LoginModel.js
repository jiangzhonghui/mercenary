define(function () {
    return Backbone.Model.extend({
        url: 'user',
        parse: function (json) {
            if (!json.artists) json.artists = [];
            return json;
        },
        isNew: function () {
            return !this.attributes.hasOwnProperty('artists');
        }
    });
});