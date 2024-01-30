package processing;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.serialization.Serializer;

import java.util.Map;

public class StockAggregateSerializer implements Serializer<StockAggregate> {

    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {
        Serializer.super.configure(configs, isKey);
    }

    @Override
    public byte[] serialize(String s, StockAggregate stockAggregate) {
        if(stockAggregate == null){
            return null;
        }
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writeValueAsBytes(stockAggregate);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
