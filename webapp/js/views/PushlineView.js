define(['text!templates/pushline.mustache', 'text!templates/pushRow.mustache', 'models/PushCollection'], function (template, pushRowTemplate, PushCollection) {
    return Backbone.View.extend({
        el: '#pushline',
        template: Hogan.compile(template),
        pushRowTemplate: Hogan.compile(pushRowTemplate),
        events: {
            'click .toggle': 'toggle'
        },
        initialize: function () {
            this.pushCollection = new PushCollection([
                {title: "Mon préféré", content: "C'est Julien Clerc !", date: 1360146126657},
                {title: "Mon préféré", content: "C'est Britney !", date: 1360146126657},
                {title: "Mon préféré", content: "C'est Madonna !", date: 1360146126657},
                {title: "Mon préféré", content: "C'est Julien Clerc !", date: 1360146126657},
                {title: "Mon préféré", content: "C'est Britney !", date: 1360146126657},
                {title: "Mon préféré", content: "C'est Madonna !", date: 1360146126657},
                {title: "Mon préféré", content: "C'est Julien Clerc !", date: 1360146126657},
                {title: "Mon préféré", content: "C'est Britney !", date: 1360146126657},
                {title: "Mon préféré", content: "C'est Madonna !"},
                {title: "Mon préféré", content: "C'est Julien Clerc !"},
                {title: "Mon préféré", content: "C'est Britney !"},
                {title: "Mon préféré", content: "C'est Madonna !"},
                {title: "Mon préféré", content: "C'est Julien Clerc !"},
                {title: "Mon préféré", content: "C'est Britney !"},
                {title: "Mon préféré", content: "C'est Madonna !"},
                {title: "Mon préféré", content: "C'est Julien Clerc !"},
                {title: "Mon préféré", content: "C'est Britney !"},
                {title: "Mon préféré", content: "C'est Madonna !"},
                {title: "Mon préféré", content: "C'est Julien Clerc !"},
                {title: "Mon préféré", content: "C'est Britney !"},
                {title: "Mon préféré", content: "C'est Madonna !"},
                {title: "Mon préféré", content: "C'est MJ !"}
            ]);
            this.render();
        },
        render: function () {
            var self = this;

            this.$el.html(this.template.render());
            this.pushCollection = new PushCollection(this.pushCollection.sortBy(function (push) {
                return push.get('date');
            }));
            this.pushCollection.each(function (pushModel) {
                self.$('ul').append(self.pushRowTemplate.render(pushModel.toJSON()));
            });
            return this;
        },
        toggle: function () {
            this.$el.toggleClass('hide');
        }
    });
});