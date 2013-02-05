#!/bin/sh
LOG_DIR=/home/mercenary/logs

stop_on_error() {
 if [ $? -ne 0 ] ; then
  echo "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!"
  echo "$1"
  echo "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!"
  exit 1
 fi
}

echo "Refreshing mercenary git repository @ $(date +'%T - %D') ..."

pushd /home/mercenary/mercenary
git checkout release
git pull --rebase >> $LOG_DIR/git-cron.log 2>&1
popd

pushd /home/mercenary/mercenary/server
npm install
stop_on_error "Unable to install modules dependencies"
popd




