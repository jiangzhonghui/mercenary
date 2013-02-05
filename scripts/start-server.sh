#!/bin/bash

source "$( cd "$( dirname "${BASH_SOURCE[0]}" )" && pwd )/common.sh"

pushd $SERVER_DIR

npm install
stop_on_error "Unable to install modules dependencies"

export NODE_ENV=prod
nohup supervisor -q -n error  server.js </dev/null > $LOG_DIR/nohup_server.log 2>&1 &
echo $$ > $LOG_DIR/nodejs.pid

popd

echo "**************************************************"
echo "Server started with PID $(cat $LOG_DIR/nodejs.pid)"
echo "**************************************************"


