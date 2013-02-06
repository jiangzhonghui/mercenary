define(['text!templates/search.mustache', './ResultView', 'models/ArtistCollection'],
    function (template, ResultView, ArtistCollection) {
        return Backbone.View.extend({
            el: '#body',
            template: Hogan.compile(template),
            events: {
                'submit #searchForm': 'searchArtists',
                'click .search-infos .prev': 'previousResults',
                'click .search-infos .next': 'nextResults'
            },
            initialize: function () {
                this.artists = new ArtistCollection();
                this.artists.on('reset', this.displayResults, this);
            },
            render: function () {
                this.transition(this.template.render());
                this.restoreSearch();
                return this;
            },
            searchArtists: function (event) {
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

                this.artists.fetch({data: $.param(searchWithPage)});
            },
            displayResults: function () {
                this.$('#nbResults').text(this.artists.size());
                this.$('.search-infos').hide().fadeIn();

                this.$('#results').empty();
                this.artists.each(function (artist) {
                    this.$('#results').append(new ResultView({model: artist}).render().el).hide().fadeIn();
                });

                this.refreshPagination();
            },
            refreshPagination: function () {
                this.$('.search-infos div').css('visibility', 'visible');
                this.$('#page').text(this.page + 1);

                if (this.page === 0) this.$('.search-infos .prev').css('visibility', 'hidden');
                if (this.artists.size() < 15) this.$('.search-infos .next').css('visibility', 'hidden');
                if (this.artists.size() === -1) this.$('.page-wrapper').css('visibility', 'hidden');
            },
            previousResults: function () {
                this.page--;
                this.searchArtists();
            },
            nextResults: function () {
                this.page++;
                this.searchArtists();
            },
            restoreSearch: function () {
                if (localStorage.currentSearch) {
                    var currentSearch = $.parseJSON(localStorage.currentSearch);
                    _.each(this.$('#searchForm input'), function (input) {
                        $(input).val(_.findWhere(currentSearch, {name: $(input).attr('name')}).value);
                    });
                    this.currentSearch = currentSearch;
                    this.page = parseInt(localStorage.searchPage) || 0;
                    this.searchArtists();
                }
            },
            keepSearch: function () {
                localStorage.currentSearch = JSON.stringify(this.currentSearch);
                localStorage.searchPage = this.page;
            }
        });
    });