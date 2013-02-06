define(['text!templates/signup.mustache', 'models/UserModel'],
    function (template, UserModel) {
        return Backbone.View.extend({
            el: '#body',
            template: Hogan.compile(template),
            events: {
                'submit': 'submit'
            },
            initialize: function () {
                this.user = new UserModel();
            },
            render: function () {
                this.transition(this.template.render());
                return this;
            },
            submit: function (event) {
                event.preventDefault();
                this.user.save({
                    email: this.$('input[name="email"]').val(),
                    username: this.$('input[name="username"]').val(),
                    city: this.$('input[name="city"]').val() + ', ' + this.$('input[name="country"]').val()
                });
            }
        });
    });