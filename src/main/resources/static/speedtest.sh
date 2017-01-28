#!/bin/sh
## Configuration
LOG_FILE=/home/steve/Documents/dev/internet-speed-log/logs/log.json
SPEEDTEST_CLI=/usr/local/bin/speedtest-cli
##

SPEED_RESULT=[$(python $SPEEDTEST_CLI --json)]
TMP=$(jq '.log |= .+ '"$SPEED_RESULT" $LOG_FILE)
echo $TMP | jq . > $LOG_FILE
echo 'Last Speedtest:'
jq '.log[-1]' $LOG_FILE
