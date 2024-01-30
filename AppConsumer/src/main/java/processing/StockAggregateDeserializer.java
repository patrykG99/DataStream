package processing;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.serialization.Deserializer;

import java.io.IOException;
import java.util.Map;

public class StockAggregateDeserializer implements Deserializer<StockAggregate> {
    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {
        Deserializer.super.configure(configs, isKey);
    }

    @Override
    public StockAggregate deserialize(String s, byte[] bytes) {
        if(bytes == null){
            return null;
        }
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(bytes, StockAggregate.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
