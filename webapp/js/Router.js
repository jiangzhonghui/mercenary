define(['backbone', 'views/MenuView'], function (Backbone, MenuView) {
    return Backbone.Router.extend({
        initialize: function () {
            new MenuView().render();
        },
        routes: {
            '': 'welcome',
            'list': 'list',
            'search': 'search'
        },
        welcome: function () {
            require([ 'views/WelcomeView' ], Mercenary.router.changeView);
        },
        list: function () {
            require([ 'views/ListView' ], Mercenary.router.changeView);
        },
        search: function () {
            require([ 'views/SearchView' ], Mercenary.router.changeView);
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
