#!/bin/bash
REPO_DIR=/home/mercenary/mercenary
LOG_DIR=$REPO_DIR/logs

stop_on_error() {
 if [ $? -ne 0 ] ; then
  echo "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!"
  echo "$1"
  echo "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!"
  exit 1
 fi
}

kill -TERM -$(cat $LOG_DIR/nodejs.pid)
stop_on_error "Unable to kill server."

echo "Server has been killed"
