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
            if (Mercenary.user) {
                json.isLogged = true;
                var favoriteArtists = Mercenary.user.get('artists');
                var artist = _.findWhere(favoriteArtists, {artist_name: this.get('artist_name')});
                if(artist) json.isFavorite = true;
            }

            return json;
        }
    });
});
