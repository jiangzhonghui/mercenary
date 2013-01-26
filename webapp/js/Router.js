define(['backbone', 'views/MenuView'], function (Backbone, MenuView) {
    return Backbone.Router.extend({
        initialize: function () {
            new MenuView().render();
        },
        routes: {
            '': 'welcome',
            'list': 'list',
            'search': 'search',
            'details/:id': 'details'
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
        details: function (itemId) {
            require([ 'views/DetailsView' ], function (view) {
                Mercenary.router.changeView(view, {itemId: itemId});
            });
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
