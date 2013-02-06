var db = require('mongojs').connect('mercenary', ['user']);

var users = [
    {
        "email": "anonymous@gmail.com",
        "username": "Anonymous",
        "loc": {
            "latitude": 48.856614,
            "longitude": 2.352222
        },
        "city": "Paris, France"
    }
];

db.user.remove({}, { safe: true }, function () {

    for (i = 0; i < users.length; i++) {
        var user = users[i];
        db.user.save(user);
    }
    db.user.ensureIndex({ loc: "2d" });
    process.exit(0);
});
