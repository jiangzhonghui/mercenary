define(['./ItemModel'], function (ItemModel) {
    return Backbone.Collection.extend({
        model: ItemModel,
        url: 'item',
        parse: function (data) {
            return data.results;
        }
    });
});