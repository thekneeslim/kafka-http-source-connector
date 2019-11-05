## Scripts

This module contains scripts for easy environment setup to start up Zookeeper & Kafka Brokers locally.

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