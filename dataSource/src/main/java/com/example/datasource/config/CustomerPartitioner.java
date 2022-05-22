package com.example.datasource.config;

import org.apache.kafka.clients.producer.Partitioner;
import org.apache.kafka.common.Cluster;

import java.util.Map;

public class CustomerPartitioner implements Partitioner {
    @Override
    public int partition(String topic, Object key, byte[] keyBytes, Object value, byte[] valueBytes1, Cluster cluster) {
        Integer k = (Integer) key;

        Integer topicNum = cluster.partitionCountForTopic(topic);
        int partion = k % topicNum;


        return partion;
    }

    @Override
    public void close() {

    }

    @Override
    public void configure(Map<String, ?> map) {

    }
}
