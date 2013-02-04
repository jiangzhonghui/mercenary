var mongoose = require('mongoose');
var SongSchema = require('../schemas/SongSchema');

var Song = mongoose.model('song', SongSchema, 'song');

var excludeArrays = {artist_mbtags: 0, artist_mbtags_count: 0, similar_artists: 0, segments_timbre: 0, segments_pitches: 0  }
var excludeLightArrays = { segments_timbre: 0, segments_pitches: 0  }

module.exports = Song;
module.exports.excludeArrays = excludeArrays;
module.exports.excludeLightArrays = excludeLightArrays;