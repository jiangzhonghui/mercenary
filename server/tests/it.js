var vows = require('vows')
  , assert = require('assert')
  , request = require('request')
  , url = 'http://localhost:3000/';

vows.describe('API access').addBatch({
    'get item': { 
        topic: function () {
            request.get(url + 'song', this.callback);
        },
        'should respond with a 200 OK': function (e, res) {
            assert.equal (res.statusCode, 200);
        }
    }
}).run();