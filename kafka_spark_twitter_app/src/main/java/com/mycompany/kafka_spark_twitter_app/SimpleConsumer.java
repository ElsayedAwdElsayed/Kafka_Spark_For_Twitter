/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.kafka_spark_twitter_app;

import java.util.Properties;

/**
 *
 * @author elsayedawd
 */
public class SimpleConsumer {

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Enter topic name");
            return;   //it will exit the application at all 
        }
        String topicName = args[0].toString();
        Properties props = new Properties();  //creating property file to be used in Consumer Configration
        props.put("bootstrap.servers", "localhost:9092");  //consumer will listen to this ip and port of the broker 
        props.put("group.id", "test"); //assign this consumer to the group of id test
        props.put("enable.auto.commit", "true");//if read an offest then this offest will be commited 
        props.put("auto.commit.interval.ms", "1000");//the updated offests consumed by the consumer will be updated every 1000ms
        props.put("session.timeout.ms", "30000");
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");





    }
}
