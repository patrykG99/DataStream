package serialization;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.serialization.Deserializer;

import java.io.IOException;
import java.util.Map;

public class StockDataDeserializer implements Deserializer<DeserializedStockData> {

    private final ObjectMapper objectMapper = new ObjectMapper();
    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {
        Deserializer.super.configure(configs, isKey);
    }

    @Override
    public DeserializedStockData deserialize(String s, byte[] bytes) {
        if(bytes == null){
            return null;
        }

        try{
            return objectMapper.readValue(bytes, DeserializedStockData.class);
        }catch (IOException e){
            throw new RuntimeException("Error deserializing JSON", e);
        }
    }
}
