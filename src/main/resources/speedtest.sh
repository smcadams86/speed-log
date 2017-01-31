#!/bin/sh
## Configuration
LOG_FILE=/data/speed-log/log.json
SPEEDTEST_CLI=/data/speed-log/speedtest-cli
##

SPEED_RESULT=[$(python $SPEEDTEST_CLI --json)]
TMP=$(jq '.log |= .+ '"$SPEED_RESULT" $LOG_FILE)
echo $TMP | jq . > $LOG_FILE
echo 'Last Speedtest:'
jq '.log[-1]' $LOG_FILE
