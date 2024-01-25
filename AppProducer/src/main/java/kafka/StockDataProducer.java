package kafka;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;

import org.apache.kafka.common.serialization.StringSerializer;


import java.util.Properties;

public class StockDataProducer {

    private final KafkaProducer<String,String> producer;


    public StockDataProducer(){
        Properties properties = new Properties();
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,"localhost:9092");
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());

        this.producer = new KafkaProducer<>(properties);
    }

    public void sendStockData(String topic, String value) {
        ProducerRecord<String, String> record = new ProducerRecord<>(topic, value);
        producer.send(record, (metadata, exception) -> {
            if (exception == null) {
                System.out.println("Sent record: " + metadata.toString());
                System.out.println("RRRRRRRRR");
            } else {
                System.out.println("RRRRRRRRR");

                exception.printStackTrace();
            }
        });
//        producer.send(record);
        producer.flush();

    }

    public void closeProducer(){
        producer.close();
    }



}
