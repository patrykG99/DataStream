package myapps;

import integration.ApiClient;
import integration.ApiResponse;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.Topology;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.ValueMapper;

import java.util.Arrays;
import java.util.Properties;
import java.util.concurrent.CountDownLatch;

public class LineSplit {
    public static void main(String[] args){

//        Properties props = new Properties();
//        props.put(StreamsConfig.APPLICATION_ID_CONFIG, "streams-linesplit");
//        props.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG,"localhost:9092");
//
//        final StreamsBuilder builder = new StreamsBuilder();
//        KStream<String,String> source = builder.stream("streams-plaintext-input");
//        source.flatMapValues(value -> Arrays.asList(value.split("\\W+")))
//                .to("streams-linesplit-output");
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
        ApiClient apiClient = new ApiClient("https://www.alphavantage.co/query?function=TIME_SERIES_INTRADAY&symbol=IBM&interval=5min&apikey=");
        ApiResponse apiResponse = apiClient.getData();
        System.out.println(apiResponse.getMetaData());
        System.out.println(apiResponse.getTimeSeries().getTimeSeriesDataMap());











    }



}
