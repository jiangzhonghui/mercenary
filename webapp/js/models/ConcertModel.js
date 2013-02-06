define(function () {
    return Backbone.Model.extend({
        defaults: {},
        idAttribute: '_id',
        url: function() {
            return 'concert/' + this.artist;
        },
        setArtist: function(artist) {
            this.artist = artist;
        }
    });
});
