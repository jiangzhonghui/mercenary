var mongoose = require('mongoose')
    , Type = mongoose.Schema.Types;

var ArtistSchema = new mongoose.Schema({
    _id: Type.ObjectId,
    artist_7digitalid: Number,
    artist_familiarity: Number,
    artist_hotttnesss: Number,
    artist_id: String,
    artist_latitude: Number,
    artist_longitude: Number,
    artist_location: String,
    artist_mbid: String,
    artist_playmeid: Number,
    artist_name: String,
    artist_mbtags: [String],
    artist_mbtags_count: [Number],
    artist_terms: [String],
    similar_artists: [String]
});

module.exports = ArtistSchema;