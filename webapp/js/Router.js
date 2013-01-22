define(['backbone', 'views/MenuView'], function (Backbone, MenuView) {
    return Backbone.Router.extend({
        initialize: function () {
            new MenuView().render();
        },
        routes: {
            '': 'welcome',
            'list': 'list'
        },
        welcome: function () {
            require([ 'views/WelcomeView' ], function (View) {
                Mercenary.router.changeView(View);
            });
        },
        list: function () {
            require([ 'views/ListView' ], function (View) {
                Mercenary.router.changeView(View);
            });
        },
        changeView: function (View) {
            if (this.currentView) {
                this.currentView.close();
            }
            this.currentView = new View();
            this.currentView.render();
        }
    });
});
