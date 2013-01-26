define(['text!./search.mustache', './ResultView', './GMapView', 'models/ItemCollection'], function (template, ResultView, GMapView, ItemCollection) {
    return Backbone.View.extend({
        el: '#body',
        template: Hogan.compile(template),
        events: {
            'submit #searchForm': 'searchItems',
            'click .search-infos .prev': 'previousResults',
            'click .search-infos .next': 'nextResults'
        },
        initialize: function () {
            this.items = new ItemCollection();
            this.items.on('reset', this.displayResults, this);
        },
        render: function () {
            this.transition(this.template.render());
            return this;
        },
        renderGMap: function () {
            this.gmap = new GMapView();
            var self = this;
            _.delay(function () {
                self.gmap.render();
            }, 1);
        },
        searchItems: function (event) {
            var search = this.$('#searchForm').serializeArray(),
                searchWithPage;

            if (event) event.preventDefault();

            if (!(this.currentSearch instanceof Array && JSON.stringify(this.currentSearch) === JSON.stringify(search))) {
                this.currentSearch = search;
                this.page = 1;
            }
            searchWithPage = _.clone(search);
            searchWithPage.push({
                name: "page",
                value: this.page || 1
            });

            this.items.fetch({data: $.param(searchWithPage)});
        },
        displayResults: function () {
            if (!this.gmap) {
                this.renderGMap();
            }
            this.gmap.empty();
            if (!this.items.isEmpty()) this.gmap.$el.fadeIn();
            else this.gmap.$el.fadeOut();

            this.$('#nbResults').text(this.items.size());
            this.$('.search-infos').hide().fadeIn();

            this.$('#results').empty();
            this.items.each(function (item) {
                this.$('#results').append(new ResultView({model: item}).render().el).hide().fadeIn();
            });

            this.refreshPagination();
        },
        refreshPagination: function () {
            this.$('.search-infos div').css('visibility', 'visible');
            this.$('#page').text(this.page);

            if (this.page === 1) this.$('.search-infos .prev').css('visibility', 'hidden');
            if (this.items.size() < 15) this.$('.search-infos .next').css('visibility', 'hidden');
            if (this.items.size() === 0) this.$('.page-wrapper').css('visibility', 'hidden');
        },
        previousResults: function () {
            this.page--;
            this.searchItems();
        },
        nextResults: function () {
            this.page++;
            this.searchItems();
        }
    });
});