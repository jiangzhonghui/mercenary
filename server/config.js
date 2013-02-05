var envs = {
    prod: {
        name: "prod",
        log: {withColor: false, logLevel: 1},
        mongoURI: "mongodb://mercenary.aws.xebiatechevent.info/mercenary"
    },
    dev: {
        name: "dev",
        log: {withColor: true, logLevel: 0},
        mongoURI: "mongodb://localhost/mercenary"
    }
};

module.exports = function (envName) {
    if (typeof  envName === "undefined" || !envs.hasOwnProperty(envName)) {
        envName = 'dev';
    }
    console.log("***********************\n" +
        "Use '%s' configuration\n" +
        "***********************", envName);
    return envs[envName];
};
