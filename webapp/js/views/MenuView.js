define(['text!templates/menu.mustache'], function (template) {
    return Backbone.View.extend({
        el: '#menu',
        template: Hogan.compile(template),
        events: {
            'click li': 'changeMenu'
        },
        render: function () {
            this.$('ul').html(this.template.render());
            return this;
        },
        changeMenu: function (event) {
            this.$('li').removeClass('active');
            $(event.currentTarget).addClass('active');
        },
        highlight: function (index) {
            this.$('li').removeClass('active');
            if (index) this.$('li:nth-child(' + index + ')').addClass('active');
        }
    });
});