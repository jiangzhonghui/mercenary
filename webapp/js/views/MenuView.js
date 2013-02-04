define(['text!templates/menu.mustache', 'models/LoginModel'], function (template, LoginModel) {
    return Backbone.View.extend({
        el: '#menu',
        template: Hogan.compile(template),
        events: {
            'click li': 'changeMenu',
            'click button.in': 'login',
            'keypress input': 'loginKb',
            'click button.out': 'logout'
        },
        initialize: function () {
            this.model = new LoginModel();
            this.listenTo(this.model, 'sync error', this.renderLogin);
            this.model.fetch();
        },
        render: function () {
            this.$('ul').html(this.template.render());
            return this;
        },
        changeMenu: function (event) {
            this.$('li').removeClass('active');
            $(event.currentTarget).addClass('active');
        },
        highlight: function (index) {
            this.$('li').removeClass('active');
            if (index) this.$('li:nth-child(' + index + ')').addClass('active');
        },
        renderLogin: function() {
            if(this.model.get('name'))
                $('#login').html(this.model.get('name') + '<button class="out">logout</button>');
            else 
                $('#login').html('<input></input><button class="in">login</button>');
        },
        loginKb: function(event) {
            if(event.which === 13)
                this.login(event);
        },
        login: function(event) {
            event.preventDefault();
            var name = $('#login').find('input').val();
            if(name)
                this.model.save({name: name});
        },
        logout: function(event) {
            event.preventDefault();
            this.model.sync('delete', this.model);
            this.model.clear();
        }
    });
});