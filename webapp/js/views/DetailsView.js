define(['text!templates/details.mustache', 'models/ArtistModel'], function (template, ArtistModel) {
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
        },
        loadedElement: function () {
        },
        goBack: function () {
            window.history.back();
        }
    });
});