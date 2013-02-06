requirejs.config({
    baseUrl: 'js',
    paths: {
        backbone: 'lib/backbone-min',
        underscore: 'lib/underscore-min',
        jquery: 'lib/jquery-min',
        noty: 'lib/noty',
        tablesorter: 'lib/jquery.tablesorter.min',
        tsWidgets: 'lib/jquery.tablesorter.widgets.min',
        mustache: 'lib/mustache',
        hogan: 'lib/hogan',
        text: 'lib/text',
        async: 'lib/async'
    },
    shim: {
        'backbone': { deps: [ 'underscore', 'jquery' ], exports: 'Backbone' },
        'underscore': { exports: '_' },
        'tablesorter': { deps: ['jquery'] },
        'tsWidgets': { deps: ['tablesorter'] },
        'noty': {deps: ['jquery']},
        'Router': { deps: [ 'backbone' ] }
    }
});

requirejs.onError = function (err) {
    console.log(err.requireType);
    console.log(err.requireModules);
};

requirejs(['Router', 'tsWidgets', 'noty', 'hogan'], function (Router) {
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

    $.noty.defaults = {
        layout: 'bottomRight',
        theme: 'default',
        dismissQueue: true, // If you want to use queue feature set this true
        timeout: 4000, // delay for closing event. Set false for sticky notifications
        force: true, // adds notification to the beginning of queue when set to true
        modal: false,
        closeWith: ['click'] // ['click', 'button', 'hover']
    };

    Mercenary.events = _.extend({}, Backbone.Events);

    Mercenary.router = new Router();
    Backbone.history.start();
});
