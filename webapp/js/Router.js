define(['backbone', 'views/MenuView'], function (Backbone, MenuView) {
    return Backbone.Router.extend({
        initialize: function () {
            this.menu = new MenuView().render();
        },
        routes: {
            '': 'welcome',
            'list': 'list',
            'search': 'search',
            'details/:id': 'details'
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
        changeView: function (View, options) {
            if (this.currentView) {
                this.currentView.close();
            }
            this.currentView = new View(options);
            this.currentView.render();
        }
    });
});
