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

KAFKA_PID=$(<$WORKING_DIRECTORY/pid/kafka.pid)
ZOOKEEPER_PID=$(<$WORKING_DIRECTORY/pid/zookeeper.pid)

printf "\n\360\237\230\210\t Killing kafka on PID $KAFKA_PID ...\n"
kill $KAFKA_PID
echo "Giving kafka time to shutdown ..."
sleep 5

printf "\n\360\237\230\210\t Killing zookeeper on PID $ZOOKEEPER_PID ...\n"
kill $ZOOKEEPER_PID
