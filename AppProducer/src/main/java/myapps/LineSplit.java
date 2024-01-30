package myapps;

import com.fasterxml.jackson.core.JsonProcessingException;
import dataGeneration.DataGenerator;
import integration.ApiClient;
import integration.ApiResponse;
import kafka.StockDataProducer;

import java.sql.SQLOutput;


public class LineSplit {
    public static void main(String[] args) throws JsonProcessingException {

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
//        ApiClient apiClient = new ApiClient("https://www.alphavantage.co/query?function=TIME_SERIES_INTRADAY&symbol=IBM&interval=5min&apikey=");
//        ApiResponse apiResponse = apiClient.getData();
        //System.out.println(apiResponse.getMetaData());
        //System.out.println(apiResponse.getTimeSeries().getTimeSeriesDataMap());


        StockDataProducer dataProducer = new StockDataProducer();




        while(true){
            try{
                dataProducer.sendStockData("stock-data","IBM",DataGenerator.convertToJson());
                Thread.sleep(1000);
            }catch (InterruptedException e){
                Thread.currentThread().interrupt();
                System.out.println("Interrupted. Closing producer");
                break;
            }
        }















    }



}
