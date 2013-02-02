define(['text!./result.mustache'], function (template) {
    return Backbone.View.extend({
        tagName: 'li',
        template: Hogan.compile(template),
        events: {
            'click': 'seeDetails'
        },
        render: function () {
            this.$el.html(this.template.render(this.model.forTemplate()));
            Backbone.trigger('gmap:add', this.model);
            return this;
        },
        seeDetails: function () {
            Mercenary.router.navigate('details/' + this.model.id, {trigger: true});
        }
    });
});