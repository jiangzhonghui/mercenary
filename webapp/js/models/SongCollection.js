define(['./SongModel'], function (SongModel) {
    return Backbone.Collection.extend({
        model: SongModel,
        url: 'song',
        parse: function (response) {
            return response.results;
        }
    });
});