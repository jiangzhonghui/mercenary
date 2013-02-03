define(['text!templates/list.mustache', 'text!templates/table-row.mustache', 'models/SongCollection'], function (template, row, SongCollection) {
    return Backbone.View.extend({
        el: '#body',
        template: Hogan.compile(template),
        row: Hogan.compile(row),
        initialize: function () {
            this.songs = new SongCollection();
        },
        render: function () {
            this.page = 0;
            this.transition(this.template.render());

            $('#items-table').tablesorter({
                theme: 'default',
                widgets: ["zebra"]
            });

            this.songs.on('reset', this.displayItems, this);
            this.songs.fetch({data: {page: this.page, results_per_page: 30}});

            $(window).scroll(function () {
                if ($(window).scrollTop() + $(window).height() == $(document).height()) {
                    this.page++;
                    this.songs.fetch({data: {page: this.page, results_per_page: 30}})
                }
            }.bind(this));
            return this;
        },
        displayItems: function () {
            var self = this;

            this.songs.each(function (song) {
                var $row = $(self.row.render(song.toJSON()));
                $row.click(function() {Mercenary.router.navigate('details/' + song.id, {trigger: true});});
                self.$('#items-table tbody').append($row);
            });
            $('#items-table').trigger('update');
        },
        close: function () {
            $(window).off('scroll');
        }
    });
});