define(['models/LoginModel'], function (LoginModel) {
    return Backbone.View.extend({
        el: '#login',
        events: {
            'click button.in': 'login',
            'click button.out': 'logout',
            'keypress input': 'loginKb'
        },
        initialize: function () {
            this.model = new LoginModel();
            this.listenTo(this.model, 'sync error', this.render);
            if (document.cookie) this.model.fetch();
            else this.render();
        },
        render: function () {
            if (this.model.get('name'))
                $('#login').html('<span class="name">' + this.model.get('name') + '</span><button class="out blue-button">logout</button>');
            else
                $('#login').html('<input type="text" placeholder="Nom"/><button class="in blue-button">login</button>');
        },
        loginKb: function (event) {
            if (event.which === 13)
                this.login(event);
        },
        login: function (event) {
            event.preventDefault();
            var name = $('#login').find('input').val();
            if (name)
                this.model.save({name: name});
        },
        logout: function (event) {
            event.preventDefault();
            this.model.sync('delete', this.model);
            this.model.clear();
        }
    });
});