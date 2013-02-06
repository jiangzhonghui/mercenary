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
            var mapOptions = {
                zoom: 6,
                center: new google.maps.LatLng(48.87525, 2.31110),
                mapTypeId: google.maps.MapTypeId.ROADMAP
            };
            this.map = new google.maps.Map(document.getElementById('heatmapArea'),
                mapOptions);

            this.heatmap = new HeatmapOverlay(this.map, {
                "radius": 30,
                "visible": true,
                "opacity": 40
            });
            this.data = {
                max: 10,
                data: [
                    {lat: 48.87525, lng: 2.31110, count: 8}
                ]
            }
            google.maps.event.addListenerOnce(this.map, "idle", function () {
                this.heatmap.setDataSet(this.data);
            }.bind(this));
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
            }, 1);
        }
    });
});