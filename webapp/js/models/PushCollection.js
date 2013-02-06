define(['./PushModel'], function (PushModel) {
    return Backbone.Collection.extend({
        model: PushModel,
        url: 'news'
    });
});