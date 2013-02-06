define(['backbone', 'views/MenuView', 'views/LoginView', 'views/PushlineView'], function (Backbone, MenuView, LoginView, PushlineView) {
    return Backbone.Router.extend({
        initialize: function () {
            this.menu = new MenuView().render();
            new LoginView();
            new PushlineView();
        },
        routes: {
            '': 'welcome',
            'list': 'list',
            'search': 'search',
            'details/:id': 'details',
            'signup': 'signup'
        },
        welcome: function () {
            require([ 'views/WelcomeView' ], Mercenary.router.changeView);
            this.menu.highlight(1);
        },
        list: function () {
            require([ 'views/ListView' ], Mercenary.router.changeView);
            this.menu.highlight(2);
        },
        search: function () {
            require([ 'views/SearchView' ], Mercenary.router.changeView);
            this.menu.highlight(3);
        },
        details: function (songId) {
            require([ 'views/DetailsView' ], function (view) {
                Mercenary.router.changeView(view, {songId: songId});
            });
            this.menu.highlight();
        },
        signup: function () {
            require([ 'views/SignupView' ], Mercenary.router.changeView);
            this.menu.highlight(4);
        },
        changeView: function (View, options) {
            if (this.currentView) {
                this.currentView.close();
            }
            this.currentView = new View(options);
            this.currentView.render();
        }
    });
});
