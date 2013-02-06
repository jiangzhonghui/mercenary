var ObjectId = require('mongoose').Types.ObjectId,
    Artist = require('../models/ArtistModel');


exports.findOne = function findOne(id, next) {
    Artist.findById(id, Artist.excludeLightArrays, function (err, artist) {
        if (err) {
            return next(err);
        }
        if (!artist) {
            return next({nothing: true});
        }
        next(artist);
    });
}



exports.findAll = function findAll(search, next) {
    Artist.find(search, Artist.excludeArrays, function (err, artists) {
        if (err) {
            return next(err);
        }
        if (!artists) {
            throw new Error('Artist not found');
        }
        next(artists);
    });
}

exports.findField = function (field, id, next) {
    var fields = {};
    fields[field] = 1;
    Artist.findById(id, fields, function (err, field) {
        if (err) {
            return next(err);
        }
        if (!field) {
            throw new Error('Artist not found');
        }
        next(field);
    });
}

exports.pagination = function pagination(search, page, results_per_page, next) {
    Artist.find(search, Artist.excludeArrays).skip(page * results_per_page).limit(parseInt(results_per_page)).exec(function (err, artists) {
        if (err) {
            return next(err);
        }
        if (!artists) {
            throw new Error('Artists not found');
        }
        next(artists);
    });
}