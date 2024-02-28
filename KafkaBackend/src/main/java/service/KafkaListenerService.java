package service;

import org.springframework.kafka.annotation.KafkaListener;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class KafkaListenerService {
    private final List<String> messages = new CopyOnWriteArrayList<>();

    @KafkaListener(topics = "aggregated-stock-data")
    public void listen(String message) {
        messages.add(message);
        // Depending on the requirement, you can also process the message before adding
    }

    public List<String> getMessages() {
        return messages;
    }
}
