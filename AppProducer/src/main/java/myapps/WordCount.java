package myapps;

import org.apache.kafka.common.serialization.Serde;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.Topology;
import org.apache.kafka.streams.kstream.*;

import java.util.Arrays;
import java.util.Properties;
import java.util.concurrent.CountDownLatch;

public class WordCount {
    public static void main(String[] args) {

//        Properties props = new Properties();
//        props.put(StreamsConfig.APPLICATION_ID_CONFIG, "streams-wordcount");
//        props.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG,"localhost:9092");
//        props.put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String().getClass());
//        props.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, Serdes.String().getClass());
//
//
//        final Serde<String> stringSerde = Serdes.String();
////        final Serde<Long> longSerde = Serdes.Long();
//
//
//
//
//        final StreamsBuilder builder = new StreamsBuilder();
//        KStream<String, String> textLines = builder.stream(
//                "streams-plaintext-input",
//                Consumed.with(stringSerde, stringSerde)
//        );
//        KTable<String, Long> wordCounts = textLines
//                // Split each text line, by whitespace, into words.
//                .flatMapValues(value -> Arrays.asList(value.toLowerCase().split("\\W+")))
//
//                // Group the text words as message keys
//                .groupBy((key, value) -> value)
//
//                // Count the occurrences of each word (message key).
//                .count();
//
//// Store the running counts as a changelog stream to the output topic.
//        wordCounts.toStream().to("streams-wordcount-output", Produced.with(Serdes.String(), Serdes.Long()));
//
//
//
//
//
//        final Topology topology = builder.build();
//        System.out.println(topology.describe());
//
//        final KafkaStreams streams = new KafkaStreams(topology, props);
//        final CountDownLatch latch = new CountDownLatch(1);
//
//        Runtime.getRuntime().addShutdownHook(new Thread("streams-shutdown-hook"){
//            @Override
//            public void run(){
//                streams.close();
//                latch.countDown();
//            }
//        });
//        try{
//            streams.start();
//            latch.await();
//        }catch (Throwable e){
//            System.exit(1);
//        }
//        System.exit(0);

    }



}
