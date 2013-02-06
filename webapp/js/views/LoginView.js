define(['models/LoginModel'], function (LoginModel) {
    return Backbone.View.extend({
        el: '#login',
        events: {
            'click button.in': 'login',
            'click button.out': 'logout'
        },
        initialize: function () {
            this.model = new LoginModel();
            this.listenTo(this.model, 'sync error', this.render);
            if (document.cookie) this.model.fetch();
            else this.render();
            this.listenTo(Backbone, 'signup', this.refresh);
        },
        render: function () {
            var username = this.model.get('username');
            if (username)
                this.$el.html('<span class="name">Hello ' + username + '</span><button class="out blue-button">logout</button>');
            else
                this.$el.html('<form><input type="text" name="name" placeholder="Name"/><button class="in blue-button">login</button></form>');
        },
        login: function (event) {
            event.preventDefault();
            var name = $('#login').find('input').val();
            if (name)
                this.model.save({mail: name});
        },
        refresh: function () {
            if (document.cookie) this.model.fetch();
        },
        logout: function (event) {
            event.preventDefault();
            this.model.sync('delete', this.model);
            this.model.clear();
        }
    });
});