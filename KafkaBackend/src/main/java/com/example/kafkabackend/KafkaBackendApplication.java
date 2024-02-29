package com.example.kafkabackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.example", "service", "controller"})
public class KafkaBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(KafkaBackendApplication.class, args);
    }

}
