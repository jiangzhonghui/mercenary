define(['text!./details.mustache', 'models/ItemModel'], function (template, ItemModel) {
    return Backbone.View.extend({
        el: '#body',
        template: Hogan.compile(template),
        initialize: function () {
            this.model = new ItemModel();
            this.model.id = this.options.itemId;
            this.model.on('change', this.renderItem, this);
        },
        render: function () {
            this.model.fetch();
            return this;
        },
        renderItem: function () {
            this.transition(this.template.render(this.model.toJSON()));
        }
    });
});