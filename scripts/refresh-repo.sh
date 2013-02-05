#!/bin/sh

source "$( cd "$( dirname "${BASH_SOURCE[0]}" )" && pwd )/common.sh"

echo "Refreshing mercenary git repository @ $(date +'%T - %D') ..."

pushd $REPO_DIR
git checkout release
git pull --rebase >> $LOG_DIR/git-cron.log 2>&1
popd

pushd $SERVER_DIR
npm install
stop_on_error "Unable to install modules dependencies"
popd




