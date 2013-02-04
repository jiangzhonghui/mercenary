requirejs.config({
    baseUrl: 'js',
    paths: {
        backbone: 'lib/backbone-min',
        underscore: 'lib/underscore-min',
        jquery: 'lib/jquery-min',
        tablesorter: 'lib/jquery.tablesorter.min',
        tsWidgets: 'lib/jquery.tablesorter.widgets.min',
        mustache: 'lib/mustache',
        hogan: 'lib/hogan',
        text: 'lib/text'
    },
    shim: {
        'backbone': { deps: [ 'underscore', 'jquery' ], exports: 'Backbone' },
        'underscore': { exports: '_' },
        'tablesorter': { deps: ['jquery'] },
        'tsWidgets': { deps: ['tablesorter'] },
        'Router': { deps: [ 'backbone' ] }
    }
});

requirejs.onError = function (err) {
    console.log(err.requireType);
    console.log(err.requireModules);
};

requirejs(['Router', 'tsWidgets', 'hogan'], function (Router) {
    var Mercenary = window.Mercenary = {};

    _.extend(Backbone.View.prototype, {
        close: function () {
            this.$el.unbind();
            this.$el.html('');
            if (this.onClose) {
                this.onClose();
            }
        },
        transition: function (render) {
            this.$el.hide();
            this.$el.html(render);
            this.$el.fadeIn(100);
        }
    });

    Mercenary.events = _.extend({}, Backbone.Events);

    Mercenary.router = new Router();
    Backbone.history.start();
});
