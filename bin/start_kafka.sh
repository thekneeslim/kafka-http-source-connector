#!/usr/bin/env bash

KAFKA_PROPERTIES=$1

if [ ! -f "$1" ]
then
  printf "\n\360\237\230\241\t Kafka properties not found! Please specify properties file as first argument!"
  exit 1
else
  printf "\n\360\237\221\200\t Using properties ...\n"
  source $KAFKA_PROPERTIES
  cat $KAFKA_PROPERTIES
fi

printf "\n\360\237\221\273\t Starting Zookeeper...\n"
echo "$KAFKA_HOME/bin/zookeeper-server-start"

${KAFKA_HOME}/bin/zookeeper-server-start $ZOOKEEPER_PROPERTIES > ${ZOOKEEPER_LOG_FILE} 2>&1 &
ZOOKEEPER_PID=$!

printf "\n\360\237\216\203\t Zookeeper PID is ${ZOOKEEPER_PID}\n"
