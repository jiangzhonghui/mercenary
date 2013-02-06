define(['text!templates/infoWindow.mustache'], function (infoWindowTemplate) {
    return Backbone.View.extend({
        el: '#heatmapArea',
        infoWindowTemplate: Hogan.compile(infoWindowTemplate),
        currentMarkers: [],
        initialize: function () {
        },
        render: function (artist) {
            console.log(artist);
            $.get('/artist/users/' + artist, function (response) {
                var data = {};
                var myArray = [];
                data.max = 3;
                _.each(response, function (user) {
                    var coord = {
                        lat: user.loc.latitude,
                        lng: user.loc.longitude,
                        count: 1
                    }
                    myArray.push(coord);
                });
                data.data = myArray;
                this.initGmaps();
                this.initHeatmap(data);
            }.bind(this));
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
        initHeatmap: function (data) {
            this.heatmap = new HeatmapOverlay(this.map, {
                "radius": 30,
                "visible": true,
                "opacity": 40
            });
            google.maps.event.addListenerOnce(this.map, "idle", function () {
                this.heatmap.setDataSet(data);
            }.bind(this));
        }
    });
});