define(['text!templates/pushline.mustache', 'text!templates/pushRow.mustache', 'models/PushCollection'], function (template, pushRowTemplate, PushCollection) {
    return Backbone.View.extend({
        el: '#pushline',
        template: Hogan.compile(template),
        pushRowTemplate: Hogan.compile(pushRowTemplate),
        events: {
            'click .toggle': 'toggle'
        },
        initialize: function () {
            this.pushCollection = new PushCollection();
            this.pushCollection.on('reset', this.render, this);
            this.loop();
        },
        render: function () {
            var self = this;

            this.$el.html(this.template.render());
            this.pushCollection.each(function (pushModel) {
                self.$('ul').append(self.pushRowTemplate.render(pushModel.toJSON()));
            });
            return this;
        },
        toggle: function () {
            this.$el.toggleClass('hide');
        },
        loop: function() {
            this.pushCollection.fetch();

            var self = this;
            _.delay(function() {
                self.loop();
            }, 50);
        }
    });
});