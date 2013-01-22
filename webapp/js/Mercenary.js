requirejs.config({
    baseUrl: 'js',
    paths: {
        backbone: 'lib/backbone-min',
        underscore: 'lib/underscore-min',
        jquery: 'lib/jquery-min',
        mustache: 'lib/mustache',
        hogan: 'lib/hogan',
        text: 'lib/text'
    },
    shim: {
        'backbone': {
            deps: [ 'underscore', 'jquery' ],
            exports: 'Backbone'
        },
        'underscore': {
            exports: '_'
        },
        'Router': {
            deps: [ 'backbone' ]
        }
    }
});

requirejs.onError = function (err) {
    console.log(err.requireType);
    console.log(err.requireModules);
};

requirejs(['Router', 'server/FakeServer', 'jquery', 'underscore', 'backbone', 'hogan'], function (Router, FakeServer) {
    var Mercenary = window.Mercenary = {};

    //Starting fake server to bind REST url
    FakeServer.start();

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
