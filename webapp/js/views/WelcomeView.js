define(['text!templates/welcome.mustache', './SignupView'], function (template, SignupView) {
    return Backbone.View.extend({
        el: '#body',
        template: Hogan.compile(template),
        initialize: function () {
        },
        render: function () {
            this.transition(this.template.render());
            this.$('#signupForm').html(new SignupView().render().$el);
            return this;
        },
        onClose: function () {

        }
    });
});