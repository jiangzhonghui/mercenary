#!/bin/sh
USER_HOME=/home/mercenary
REPO_DIR=$USER_HOME/mercenary
SERVER_DIR=$REPO_DIR/server
LOG_DIR=/home/mercenary/logs

stop_on_error() {
 if [ $? -ne 0 ] ; then
  echo "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!"
  echo "$1"
  echo "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!"
  exit 1
 fi
}

[[ -s $USER_HOME/.nvm/nvm.sh ]] && . $USER_HOME/.nvm/nvm.sh # This loads NVM
nvm use 0.8.17
