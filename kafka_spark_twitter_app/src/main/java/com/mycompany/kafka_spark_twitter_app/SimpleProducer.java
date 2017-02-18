/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.kafka_spark_twitter_app;

import java.util.Properties;
//import util.properties packages
import org.apache.kafka.clients.producer.Producer;
//import simple producer packages
import org.apache.kafka.clients.producer.KafkaProducer;
//import KafkaProducer packages
import org.apache.kafka.clients.producer.ProducerRecord;
//import ProducerRecord packages

public class SimpleProducer {
//Create java class named “SimpleProducer”

    public static void main(String[] args) throws Exception {
        if (args.length == 0) // Check arguments length value
        {
            System.out.println("Enter topic name");
            return;
        }
        String topicName = args[0];
//Assign topicName to string variable
        Properties props = new Properties();
// create instance for properties to access producer configs
        props.put("bootstrap.servers", "localhost:9092");
//Assign localhost id
        props.put("acks", "all");
//Set acknowledgements for producer requests.
        props.put("retries", 0);
//If the request fails, the producer can automatically retry,
        props.put("batch.size", 16384);
//Specify buffer size in config
        props.put("linger.ms", 1);
//Reduce the no of requests less than 0
        props.put("buffer.memory", 33554432);
//The buffer.memory controls the total amount of memory available to

        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        try (Producer<String, String> producer = new KafkaProducer<>(props)) {
            for (int i = 0; i < 10; i++) {
                producer.send(new ProducerRecord<>(topicName,
                        Integer.toString(i), Integer.toString(i))); //send the message to topic that is contained in
                //in broker Producer record is contain(topic_name,record_key,record_content)
            }
            System.out.println("Message sent successfully");
        }
    }
}
