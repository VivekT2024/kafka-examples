package com.vivekt.kafka;

//mport com.example.kafka.model.Message;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

    // Method to consume JSON message
    @KafkaListener(topics = "topic-person", groupId = "test-group")
    public void consumeMessage(JsonNode message) {
        System.out.println("Received message: " + message);
    }
}