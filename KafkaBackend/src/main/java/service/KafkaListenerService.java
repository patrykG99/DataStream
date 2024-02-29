package service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
@Service
public class KafkaListenerService {
    private final List<String> messages = new CopyOnWriteArrayList<>();

    @KafkaListener(topics = "aggregated-stock-data")
    public void listen(String message) {
        messages.add(message);
    }

    public List<String> getMessages() {
        return messages;
    }
}
