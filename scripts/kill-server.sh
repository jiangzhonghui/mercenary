#!/bin/bash

source $REPO_DIR/scripts/common.sh

kill -TERM -$(cat $LOG_DIR/nodejs.pid)
stop_on_error "Unable to kill server."

echo "Server has been killed"
