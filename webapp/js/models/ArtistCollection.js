define(['./ArtistModel'], function (ArtistModel) {
    return Backbone.Collection.extend({
        model: ArtistModel,
        url: 'artist'
    });
});

