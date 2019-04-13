package com.sunyt.mindcoll.model;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class MyBean {
    @KafkaListener(topics = "someTopic")
    public void processMessage(String content){

    }
}
