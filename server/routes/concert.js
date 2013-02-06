var Request = require('request').defaults({json: true})

module.exports = function (app, logger) {
    app.get('/concert/:artist', function (req, res) {
        artist_name = req.param('artist'),
        url = "http://ws.audioscrobbler.com/2.0/?method=artist.getevents&artist="+ artist_name +"&api_key=8d324eaae49baca28f4c9dbadbfa11bb&format=json"
        request(url, function (error, response, body) {
          if (!error && response.statusCode == 200) {
            res.send(body);
          } else {
            console.log("CANNOT RETRIEVE LAST FM CONCERT for artist search '" + artist_name + "'");
          }
        })    
    });
}