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
        heatmap: 'lib/heatmap',
        heatmapgmaps: 'lib/heatmap-gmaps',
        async: 'lib/async'
    },
    shim: {
        'backbone': { deps: [ 'underscore', 'jquery' ], exports: 'Backbone' },
        'underscore': { exports: '_' },
        'tablesorter': { deps: ['jquery'] },
        'tsWidgets': { deps: ['tablesorter'] },
        'noty': {deps: ['jquery']},
        'heatmapgmaps': {
            deps: ['heatmap', 'async!http://maps.google.com/maps/api/js?sensor=false']
        },
        'Router': { deps: [ 'backbone' ] }
    }
});

requirejs.onError = function (err) {
    console.log(err.requireType);
    console.log(err.requireModules);
};

requirejs(['Router', 'tsWidgets', 'noty', 'hogan', 'heatmap', 'heatmapgmaps'], function (Router) {
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
        theme: 'defaultTheme',
        type: 'alert',
        text: '',
        dismissQueue: true, // If you want to use queue feature set this true
        template: '<div class="noty_message"><span class="noty_text"></span><div class="noty_close"></div></div>',
        animation: {
            open: {height: 'toggle'},
            close: {height: 'toggle'},
            easing: 'swing',
            speed: 500 // opening & closing animation speed
        },
        timeout: false, // delay for closing event. Set false for sticky notifications
        force: false, // adds notification to the beginning of queue when set to true
        modal: false,
        closeWith: ['click'], // ['click', 'button', 'hover']
        callback: {
            onShow: function () {
            },
            afterShow: function () {
            },
            onClose: function () {
            },
            afterClose: function () {
            }
        },
        buttons: false // an array of buttons
    };

    Mercenary.events = _.extend({}, Backbone.Events);

    Mercenary.router = new Router();
    Backbone.history.start();
});
