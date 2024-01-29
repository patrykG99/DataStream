package processing;

import com.fasterxml.jackson.databind.JsonSerializer;
import org.apache.kafka.common.serialization.Serde;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.kstream.*;
import serialization.DeserializedStockData;
import serialization.StockDataDeserializer;
import serialization.StockDataSerializer;

import java.time.Duration;

public class StockDataProcessor {
    private final StreamsBuilder builder;

    final Serde<String> stringSerde = Serdes.String();
    final Serde<DeserializedStockData> deserializedStockDataSerde = Serdes.serdeFrom(new StockDataSerializer(),new StockDataDeserializer());

    public StockDataProcessor() {
        this.builder = new StreamsBuilder();
    }

    public void process(){

        KStream<String,DeserializedStockData> sourceStream = builder.stream("stock-data",Consumed.with(stringSerde,deserializedStockDataSerde));


        KTable<Windowed<String>,StockAggregate> aggregateKTable = sourceStream
                .groupByKey()
                .windowedBy(TimeWindows.of(Duration.ofMinutes(15)))
                .aggregate(
                        StockAggregate::new,
                        (key,value,aggregate) -> aggregate.update(value),
                        Materialized.as("aggregated-stock-data")

                );
    }

}
