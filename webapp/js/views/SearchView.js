define(['text!./search.mustache', './ResultView', './GMapView', 'models/SongCollection'],
    function (template, ResultView, GMapView, SongCollection) {
        return Backbone.View.extend({
            el: '#body',
            template: Hogan.compile(template),
            events: {
                'submit #searchForm': 'searchSongs',
                'click .search-infos .prev': 'previousResults',
                'click .search-infos .next': 'nextResults'
            },
            initialize: function () {
                this.songs = new SongCollection();
                this.songs.on('reset', this.displayResults, this);
            },
            render: function () {
                this.transition(this.template.render());
                this.restoreSearch();
                return this;
            },
            renderGMap: function () {
                this.gmap = new GMapView();
                var self = this;
                _.delay(function () {
                    self.gmap.render();
                }, 1);
            },
            searchSongs: function (event) {
                var search = this.$('#searchForm').serializeArray(),
                    searchWithPage;

                if (event) event.preventDefault();

                if (!(this.currentSearch instanceof Array && JSON.stringify(this.currentSearch) === JSON.stringify(search))) {
                    this.currentSearch = search;
                    this.page = 0;
                }
                searchWithPage = _.clone(search);
                searchWithPage.push({
                    name: "page",
                    value: this.page || 0
                });
                searchWithPage.push({
                    name: "results_per_page",
                    value: "15"
                })
                this.keepSearch();

                this.songs.fetch({data: $.param(searchWithPage)});
            },
            displayResults: function () {
                if (!this.gmap) {
                    this.renderGMap();
                }
                this.gmap.empty();
                if (!this.songs.isEmpty()) this.gmap.$el.fadeIn();
                else this.gmap.$el.fadeOut();

                this.$('#nbResults').text(this.songs.size());
                this.$('.search-infos').hide().fadeIn();

                this.$('#results').empty();
                this.songs.each(function (song) {
                    this.$('#results').append(new ResultView({model: song}).render().el).hide().fadeIn();
                });

                this.refreshPagination();
            },
            refreshPagination: function () {
                this.$('.search-infos div').css('visibility', 'visible');
                this.$('#page').text(this.page + 1);

                if (this.page === 0) this.$('.search-infos .prev').css('visibility', 'hidden');
                if (this.songs.size() < 15) this.$('.search-infos .next').css('visibility', 'hidden');
                if (this.songs.size() === -1) this.$('.page-wrapper').css('visibility', 'hidden');
            },
            previousResults: function () {
                this.page--;
                this.searchSongs();
            },
            nextResults: function () {
                this.page++;
                this.searchSongs();
            },
            restoreSearch: function () {
                if (localStorage.currentSearch) {
                    var currentSearch = $.parseJSON(localStorage.currentSearch);
                    _.each(this.$('#searchForm input'), function (input) {
                        $(input).val(_.findWhere(currentSearch, {name: $(input).attr('name')}).value);
                    });
                    this.currentSearch = currentSearch;
                    this.page = parseInt(localStorage.searchPage) || 0;
                    this.searchSongs();
                }
            },
            keepSearch: function () {
                localStorage.currentSearch = JSON.stringify(this.currentSearch);
                localStorage.searchPage = this.page;
            }
        });
    });