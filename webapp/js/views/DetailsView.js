define(['text!templates/details.mustache', 'models/ArtistModel', 'views/GMapView', 'models/ConcertModel'], function (template, ArtistModel, GMapView, ConcertModel) {
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

            this.modelConcert = new ConcertModel();
            this.modelConcert.on('sync', this.renderConcert, this);
        },
        render: function () {
            this.model.fetch();
            return this;
        },
        renderArtist: function () {
            this.transition(this.template.render(this.model.forTemplate()));
            this.renderGMap();
            this.fetchConcert();
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
                self.gmap.render();
            }.bind(this), 1);
        },
        fetchConcert: function() {
            this.modelConcert.setArtist(this.model.get('artist_name'));
            this.modelConcert.fetch();
        },
        renderConcert: function() {
            var events = this.modelConcert.get('events');
            _.each(events.event, function(e) {
                this.$('#venues').append('<li>' + e.venue.name + ' - ' +e.venue.location.city + ' - ' + e.venue.phonenumber + '</li>');
            });
        }
    });
});