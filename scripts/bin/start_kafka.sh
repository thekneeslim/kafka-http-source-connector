#!/usr/bin/env bash

KAFKA_PROPERTIES=$1

if [ ! -f "$1" ]
then
  printf "\n\360\237\230\241\t Kafka properties not found! Please specify properties file as first argument!\n"
  exit 1
else
  printf "\n\360\237\221\200\t Using properties ...\n"
  source $KAFKA_PROPERTIES
  cat $KAFKA_PROPERTIES
fi

printf "\n\360\237\221\273\t Creating directory structure ...\n"
rm -rf $WORKING_DIRECTORY/pid
rm -rf $WORKING_DIRECTORY/logs
mkdir $WORKING_DIRECTORY/pid
mkdir $WORKING_DIRECTORY/logs

printf "\n\360\237\221\273\t Starting Zookeeper...\n"
echo "$KAFKA_HOME/bin/zookeeper-server-start"

${KAFKA_HOME}/bin/zookeeper-server-start $ZOOKEEPER_PROPERTIES > ${WORKING_DIRECTORY}/logs/zookeeper.logs 2>&1 &

ZOOKEEPER_PID=$!
printf "\n\360\237\216\203\t Zookeeper PID is ${ZOOKEEPER_PID}\n"
echo ${ZOOKEEPER_PID} >> ${WORKING_DIRECTORY}/pid/zookeeper.pid
printf "\360\237\216\203\t Zookeeper logs can be found at ${WORKING_DIRECTORY}/logs/zookeeper.pid\n"
echo "Giving time for zookeeper to start..."

sleep 5s

printf "\n\360\237\221\273\t Starting Kafka...\n"
echo "$KAFKA_HOME/bin/kafka-server-start"

${KAFKA_HOME}/bin/kafka-server-start $KAFKA_BROKER_PROPERTIES > ${WORKING_DIRECTORY}/logs/kafka.logs 2>&1 &

KAFKA_BROKER_PID=$!
printf "\n\360\237\216\203\t Kafka Broker PID is ${KAFKA_BROKER_PID}\n"
echo ${KAFKA_BROKER_PID} >> ${WORKING_DIRECTORY}/pid/kafka.pid
printf "\360\237\216\203\t Kafka Broker logs can be found at  ${WORKING_DIRECTORY}/logs/kafka.pid\n"