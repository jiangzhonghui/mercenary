define(['text!./list.mustache', 'models/ItemCollection'], function (template, ItemCollection) {
    return Backbone.View.extend({
        el: '#body',
        template: Hogan.compile(template),
        initialize: function () {
            this.items = new ItemCollection();
        },
        render: function () {
            this.transition(this.template.render());

            this.items.on('reset', this.displayItems, this);
            this.items.fetch();

            return this;
        },
        displayItems: function () {
            var self = this;

            this.items.models.forEach(function (item) {
                self.$('#items-list').append('<li><span class="author">' + item.get('from_user') + ' : </span>' + item.get('text') + '</li>');
            });
        }
    });
});