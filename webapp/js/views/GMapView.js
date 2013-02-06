define(['text!templates/infoWindow.mustache'], function (infoWindowTemplate) {
    return Backbone.View.extend({
        el: '#heatmapArea',
        infoWindowTemplate: Hogan.compile(infoWindowTemplate),
        currentMarkers: [],
        initialize: function () {
        },
        render: function () {
            this.initGmaps();
            this.initHeatmap();
        },
        initGmaps: function () {
            var mapOptions = {
                zoom: 2,
                center: new google.maps.LatLng(48.87525, 2.31110),
                mapTypeId: google.maps.MapTypeId.ROADMAP
            };
            this.map = new google.maps.Map(document.getElementById('heatmapArea'),
                mapOptions);
        },
        initHeatmap: function () {
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
        }
    });
});