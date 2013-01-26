define(['text!./list.mustache', 'text!./table-row.mustache', 'models/ItemCollection'], function (template, row, ItemCollection) {
    return Backbone.View.extend({
        el: '#body',
        template: Hogan.compile(template),
        row: Hogan.compile(row),
        initialize: function () {
            this.items = new ItemCollection();
        },
        render: function () {
            this.transition(this.template.render());

            $('#items-table').tablesorter({
                theme: 'default',
                widgets: ["zebra"]
            });

            this.items.on('reset', this.displayItems, this);
            this.items.fetch();

            return this;
        },
        displayItems: function () {
            var self = this;

            this.items.each(function (item) {
                self.$('#items-table tbody').append(self.row.render(item.toJSON()));
            });
            $('#items-table').trigger('update');
        }
    });
});