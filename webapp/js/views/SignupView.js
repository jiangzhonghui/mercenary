define(['text!templates/signup.mustache', 'models/UserModel'],
    function (template, UserModel) {
        return Backbone.View.extend({
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
                    mail: this.$('input[name="mail"]').val(),
                    username: this.$('input[name="username"]').val(),
                    city: this.$('input[name="city"]').val() + ', ' + this.$('input[name="country"]').val()
                }, {
                    success: function () {
                        Mercenary.router.navigate('#', {trigger: true});
                        $('input[name="mail"]').val('');
                        $('input[name="username"]').val('');
                        $('input[name="city"]').val('');
                        $('input[name="country"]').val('');
                        Backbone.trigger('signup');
                    },
                    error: function () {
                        noty({
                            text: 'Votre inscription n‘a pas pu aboutir.',
                            type: 'error'
                        });
                    }
                });
            }
        });
    });