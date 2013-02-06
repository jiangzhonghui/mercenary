define(['text!templates/details.mustache', 'models/ArtistModel', 'views/GMapView'], function (template, ArtistModel, GMapView) {
    return Backbone.View.extend({
        el: '#body',
        template: Hogan.compile(template),
        events: {
            'click .details-back': 'goBack'
        },
        initialize: function () {
            this.model = new ArtistModel();
            this.model.id = this.options.artistId;
            this.model.on('change', this.renderArtist, this);
            this.model.on('load', this.loadedElement, this);
        },
        render: function () {
            this.model.fetch();
            return this;
        },
        renderArtist: function () {
            this.transition(this.template.render(this.model.forTemplate()));
            this.renderGMap();
        },
        loadedElement: function () {
        },
        goBack: function () {
            window.history.back();
        },
        renderGMap: function () {
            this.gmap = new GMapView();
            var self = this;
            _.delay(function () {
                self.gmap.render(this.model.id);
            }.bind(this), 1);
        }
    });
});