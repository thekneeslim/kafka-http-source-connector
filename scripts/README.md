## Scripts

This module contains scripts for easy environment setup to start up Zookeeper & Kafka Brokers locally. The scripts are meant to run on the confluent stack. If you are running vanilla Kafka, add a `.sh` behind each script within `start_kafka.sh`.

To start the cluster, run the following command with a configuration file as shown:-

```
./bin/start_kafka.sh kafka.properties
```

A sample `kafka.properties` file:-

```
KAFKA_HOME=/some/dir
ZOOKEEPER_PROPERTIES=/some/dir/etc/kafka/zookeeper.properties
ZOOKEEPER_LOG_FILE=/some/dir/log/zookeeper.log
```

The configurations have been set to start up:-
* 1 zookeeper node
* 1 kafka broker

## Debugging
To enable more verbose logs, go to `log4j.properties` and change output level to `DEBUG`