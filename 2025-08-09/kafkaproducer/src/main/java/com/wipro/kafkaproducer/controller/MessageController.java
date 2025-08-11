package com.wipro.kafkaproducer.controller;

import com.wipro.kafkaproducer.model.Subject;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/publish")
public class MessageController {

    private final KafkaTemplate<String, Subject> kafkaTemplate;
    private static final String TOPIC = "learn-subject";

    public MessageController(KafkaTemplate<String, Subject> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @PostMapping
    public String sendMessage(@RequestBody Subject subject) {
        kafkaTemplate.send(TOPIC, subject);
        return "Subject message sent: " + subject.toString();
    }
}
