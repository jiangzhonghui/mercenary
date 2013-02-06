define(['text!templates/result.mustache'], function (template) {
    return Backbone.View.extend({
        tagName: 'li',
        template: Hogan.compile(template),
        events: {
            'click :not(.star)': 'seeDetails',
            'click .star': 'starArtist'
        },
        render: function () {
            this.$el.html(this.template.render(this.model.forTemplate()));
            return this;
        },
        seeDetails: function () {
            Mercenary.router.navigate('details/' + this.model.id, {trigger: true});
        },
        starArtist: function () {
            Mercenary.user.get('artists').push({
                artist_id: this.model.get('artist_id'),
                artist_name: this.model.get('artist_name')
            });
            Mercenary.user.save({success: this.render});
            noty({
                text: 'Artist' + this.model.get('artist_name') + ' has been starded !',
                type: 'success'
            });
        }
    });
});