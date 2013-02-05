#!/bin/bash
LOG_DIR=/home/mercenary/logs

export NODE_ENV=prod

pushd /home/mercenary/mercenary/server
nohup supervisor -q -n error  server.js </dev/null > $LOG_DIR/nohup_server.log 2>&1 &
echo $$ > $LOG_DIR/nodejs.pid

echo "**************************************************"
echo "Server started with PID $(cat $LOG_DIR/nodejs.pid)"
echo "**************************************************"

popd
