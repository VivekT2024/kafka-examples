package com.vivekt.kafka;

//import com.example.kafka.model.Message;
//import com.example.kafka.service.KafkaProducerService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/kafka")
public class KafkaController {

    private final KafkaProducerService producerService;

    public KafkaController(KafkaProducerService producerService) {
        this.producerService = producerService;
    }

    // Endpoint to publish a JSON message
    @PostMapping("/publish")
    public String publishMessage(@RequestBody Message message) {
        producerService.sendMessage(message);
        return "Message sent to Kafka topic: " + message;
    }
}