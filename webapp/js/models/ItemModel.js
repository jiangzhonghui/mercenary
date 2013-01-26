define(function () {
    return Backbone.Model.extend({
        idAttribute: '_id',
        urlRoot: 'item'
    });
});