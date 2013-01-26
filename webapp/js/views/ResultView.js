define(['text!./result.mustache'], function (template) {
    return Backbone.View.extend({
        template: Hogan.compile(template),
        render: function () {
            this.$el.html(this.template.render(this.model.toJSON()));
            return this;
        }
    });
});