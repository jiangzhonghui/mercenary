define(['text!./details.mustache', 'models/SongModel'], function (template, SongModel) {
    return Backbone.View.extend({
        el: '#body',
        template: Hogan.compile(template),
        initialize: function () {
            this.model = new SongModel();
            this.model.id = this.options.songId;
            this.model.on('change', this.renderSong, this);
        },
        render: function () {
            this.model.fetch();
            return this;
        },
        renderSong: function () {
            this.transition(this.template.render(this.model.toJSON()));
        }
    });
});