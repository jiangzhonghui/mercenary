define(['text!templates/infoWindow.mustache', 'async!http://maps.google.com/maps/api/js?key=AIzaSyAInovLpMIXZHoapvG-gduf--guMd6FntQ&sensor=true!callback'], function (infoWindowTemplate) {
    return Backbone.View.extend({
        el: '#mapCanvas',
        infoWindowTemplate: Hogan.compile(infoWindowTemplate),
        currentMarkers: [],
        initialize: function () {
            this.geocoder = new google.maps.Geocoder();
            this.imageMarker = new google.maps.MarkerImage(
                './img/map-point.png',
                new google.maps.Size(48, 48), // taille
                new google.maps.Point(0, 0), // The origin for this image
                new google.maps.Point(5, 45) // The anchor for this image
            );
            this.infowindow = new google.maps.InfoWindow();

            this.listenTo(Backbone, 'gmap:add', this.addMarker);
        },
        render: function () {
            var latlng = new google.maps.LatLng(25, 0); // (37.300275, -99.843750); // USA (48.5, 2); // France
            var myOptions = {
                zoom: 2, // 4,
                center: latlng,
                mapTypeId: google.maps.MapTypeId.ROADMAP //ROADMAP HYBRID
            };
            this.map = new google.maps.Map(this.el, myOptions);
        },
        addMarker: function (song) {
            var self = this;

            // Localisation par nom de ville
            this.geocoder.geocode({ 'address': song.get('artist_location')}, function (results, status) {
                if (status == google.maps.GeocoderStatus.OK) {
                    var marker = new google.maps.Marker({
                        title: song.get('title'),
                        position: results[0].geometry.location,
                        map: self.map,
                        icon: self.imageMarker
                    });
                    google.maps.event.addListener(marker, 'click', function () {
                        self.infowindow.setContent(self.infoWindowTemplate.render(song.toJSON()));
                        self.infowindow.open(this.map, marker);
                    });
                    self.currentMarkers.push(marker);
                } else {
                    console.log('Localization of ' + song.get('artist_location') + ' not found');
                }
            });
        },
        empty: function () {
            _.each(this.currentMarkers, function (marker) {
                marker.setMap(null);
            });
            this.currentMarkers = [];
        }
    });
});