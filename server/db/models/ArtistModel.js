var mongoose = require('mongoose');
var ArtistSchema = require('../schemas/ArtistSchema');

var Artist = mongoose.model('artist', ArtistSchema, 'artist');

var excludeArrays = {}
var excludeLightArrays = {}

module.exports = Artist;
module.exports.excludeArrays = excludeArrays;
module.exports.excludeLightArrays = excludeLightArrays;