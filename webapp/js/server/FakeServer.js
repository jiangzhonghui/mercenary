define(['server/backbone.faux.server', 'text!./items.json'], function (fauxServer, items) {
    return {
        start: function () {
            fauxServer.addRoutes({
                getItemsList: {
                    urlExp: 'item',
                    httpMethod: 'GET',
                    handler: function () {
                        return JSON.parse(items);
                    }
                }
            })
        },
        getVersion: function () {
            return fauxServer.getVersion();
        }
    }
})
;