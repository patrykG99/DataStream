package controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.KafkaListenerService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DataController {
    private final KafkaListenerService kafkaListenerService;

    public DataController(KafkaListenerService kafkaListenerService){
        this.kafkaListenerService = kafkaListenerService;
    }
    @GetMapping("/messages")
    public ResponseEntity<List<String>> getMessages(){
        System.out.println("hehe");
        return ResponseEntity.ok().body(kafkaListenerService.getMessages());
    }
}
