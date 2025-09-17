import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.time.Duration;
import java.util.Collections;
import java.util.Properties;

public class StringKafkaConsumer {
    public static void main(String[] args) {
        // Consumer configuration
        Properties props = new Properties();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092"); // Kafka broker
        props.put(ConsumerConfig.GROUP_ID_CONFIG, "string-consumer-group");   // Consumer group
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");       // Start from earliest messages

        // Create consumer
        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props);

        // Subscribe to a topic
        String topic = "my-string-topic";
        consumer.subscribe(Collections.singletonList(topic));

        try {
            while (true) {
                // Poll for records
                ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(1000));

                for (ConsumerRecord<String, String> record : records) {
                    System.out.printf("Consumed record -> key: %s, value: %s, partition: %d, offset: %d%n",
                            record.key(), record.value(), record.partition(), record.offset());
                }
            }
        } finally {
            consumer.close(); // Ensure consumer closes on shutdown
        }
    }
}
