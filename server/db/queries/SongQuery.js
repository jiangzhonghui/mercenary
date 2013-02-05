var ObjectId = require('mongoose').Types.ObjectId,
    Song = require('../models/SongModel');

exports.save = function save(jsonSong, next) {
    new Song(jsonSong).save(function (err, song) {
        if (err) {
            return next(err);
        }
        if (!song) {
            throw  new Error('Song not found');
        }
        next(song);
    })
}

exports.findOne = function findOne(id, next) {
    Song.findById(id, Song.excludeLightArrays, function (err, song) {
        if (err) {
            return next(err);
        }
        if (!song) {
            return next({nothing: true});
        }
        next(song);
    });
}

exports.update = function update(jsonSong, next) {
    new Song(jsonSong).update(function (err, song) {
        if (err) {
            return next(err);
        }
        if (!song) {
            throw new Error('Song not found');
        }
        next(song);
    });
}

exports.remove = function remove(id, next) {
    Song.remove({_id: id}, function (err, song) {
        if (err) {
            return next(err);
        }
        if (!song) {
            throw new Error('Song not found');
        }
        next(song);
    });
}

exports.findAll = function findAll(search, next) {
    Song.find(search, Song.excludeArrays, function (err, songs) {
        if (err) {
            return next(err);
        }
        if (!songs) {
            throw new Error('Song not found');
        }
        next(songs);
    });
}

exports.findField = function (field, id, next) {
    var fields = {};
    fields[field] = 1;
    Song.findById(id, fields, function (err, field) {
        if (err) {
            return next(err);
        }
        if (!field) {
            throw new Error('Song not found');
        }
        next(field);
    });
}

exports.pagination = function pagination(search, page, results_per_page, next) {
    Song.find(search, Song.excludeArrays).skip(page * results_per_page).limit(parseInt(results_per_page)).exec(function (err, songs) {
        if (err) {
            return next(err);
        }
        if (!songs) {
            throw new Error('Songs not found');
        }
        next(songs);
    });
}