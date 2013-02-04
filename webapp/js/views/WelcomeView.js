define(['text!templates/welcome.mustache' ], function (template) {
    return Backbone.View.extend({
        el: '#body',
        template: Hogan.compile(template),
        initialize: function () {

        },
        render: function () {
            this.transition(this.template.render());
            return this;
        },
        onClose: function () {

        }
    });
});