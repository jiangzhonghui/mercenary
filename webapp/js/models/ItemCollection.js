define(['./ItemModel'], function (ItemModel) {
    return Backbone.Collection.extend({
        model: ItemModel,
        url: 'item',
        parse: function (json) {
            return json.results;
        }
    });
});