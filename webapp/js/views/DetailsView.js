define(['text!templates/details.mustache', 'models/SongModel'], function (template, SongModel) {
    return Backbone.View.extend({
        el: '#body',
        template: Hogan.compile(template),
        events: {
            'click .details-back': 'goBack'
        },
        initialize: function () {
            this.model = new SongModel();
            this.model.id = this.options.songId;
            this.model.on('change', this.renderSong, this);
            this.model.on('load', this.loadedElement, this);
        },
        render: function () {
            this.model.fetch();
            return this;
        },
        renderSong: function () {
            this.model.load('segments_pitches');
            this.transition(this.template.render(this.model.forTemplate()));
        },
        loadedElement: function () {
        },
        goBack: function () {
            window.history.back();
        }
    });
});