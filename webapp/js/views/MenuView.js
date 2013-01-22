define(['text!./menu.mustache'], function (template) {
    return Backbone.View.extend({
        el: '.menu',
        template: Hogan.compile(template),
        initialize: function () {
        },
        render: function () {
            this.$el.html(this.template.render());
            var that = this;
            this.$el.children().click(function () {
                that.$el.children().removeClass('selected');
                $(this).addClass('selected');
            });
            return this;
        }
    });
});