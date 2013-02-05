#!/bin/bash
export NODE_ENV=prod
LOG_DIR=/home/mercenary/logs

stop_on_error() {
 if [ $? -ne 0 ] ; then
  echo "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!"
  echo "$1"
  echo "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!"
  exit 1
 fi
}

pushd /home/mercenary/mercenary/server
npm install
stop_on_error "Unable to install modules dependencies"
nohup supervisor -q -n error  server.js </dev/null > $LOG_DIR/nohup_server.log 2>&1 &
echo $$ > $LOG_DIR/nodejs.pid

echo "**************************************************"
echo "Server started with PID $(cat $LOG_DIR/nodejs.pid)"
echo "**************************************************"

popd
