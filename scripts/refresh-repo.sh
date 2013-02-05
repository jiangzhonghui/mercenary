#!/bin/sh
REPO_DIR=/home/mercenary/mercenary
LOG_DIR=/home/mercenary/logs

pushd $REPO_DIR
git checkout release
git pull --rebase >> $LOG_DIR/git-cron.log 2>&1
popd

