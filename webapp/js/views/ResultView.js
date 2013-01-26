define(['text!./result.mustache'], function (template) {
    return Backbone.View.extend({
        tagName: 'li',
        template: Hogan.compile(template),
        render: function () {
            this.$el.html(this.template.render(this.model.toJSON()));
            Backbone.trigger('gmap:add', this.model);
            return this;
        }
    });
});