#!/bin/sh
USER_HOME=/home/mercenary/
LOG_DIR=$USER_HOME/logs

stop_on_error() {
 if [ $? -ne 0 ] ; then
  echo "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!"
  echo "$1"
  echo "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!"
  exit 1
 fi
}

echo "Refreshing mercenary git repository @ $(date +'%T - %D') ..."
[[ -s $USER_HOME/.nvm/nvm.sh ]] && . $USER_HOME/.nvm/nvm.sh # This loads NVM
nvm use 0.8.17

pushd $USER_HOME/mercenary
git checkout release
git pull --rebase >> $LOG_DIR/git-cron.log 2>&1
popd

pushd $USER_HOME/mercenary/server
npm install
stop_on_error "Unable to install modules dependencies"
popd




