package com.vivekt.kafka;

//import com.example.kafka.model.Message;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerService {

    private final KafkaTemplate<String, JsonNode> kafkaTemplate;
    private final String topic = "topic-person"; // Use the topic defined in application.properties

    public KafkaProducerService(KafkaTemplate<String, JsonNode> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    // Method to send JSON message
//    public void sendMessage(Message message) {
//        kafkaTemplate.send(topic, message);
//    }

    public void sendMessage(com.vivekt.kafka.Message message) {
        // ... producer configuration
        ObjectMapper objectMapper = new ObjectMapper();

            JsonNode jsonNode = objectMapper.valueToTree(message); // Convert Message to JsonNode
            //kafkaTemplate.send(new ProducerRecord<>(topic, jsonNode));
            kafkaTemplate.send(topic, jsonNode);

            // Handle serialization error

    }
}
