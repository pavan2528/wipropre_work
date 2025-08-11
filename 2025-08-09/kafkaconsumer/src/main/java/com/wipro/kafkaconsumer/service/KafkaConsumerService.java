package com.wipro.kafkaconsumer.service;

import com.wipro.kafkaconsumer.model.Subject;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

    @KafkaListener(topics = "learn-subject", groupId = "my-group")
    public void consumeSubject(Subject subject) {
        System.out.println("Received Subject: " + subject);
    }
}
