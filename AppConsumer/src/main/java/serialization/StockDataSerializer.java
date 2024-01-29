package serialization;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.serialization.Serializer;

import java.util.Map;

public class StockDataSerializer implements Serializer<DeserializedStockData> {

    private final ObjectMapper objectMapper = new ObjectMapper();
    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {
        Serializer.super.configure(configs, isKey);
    }

    @Override
    public byte[] serialize(String s, DeserializedStockData deserializedStockData) {
        if(deserializedStockData == null)
            return null;

        try{
            return objectMapper.writeValueAsBytes(deserializedStockData);
        }catch (JsonProcessingException e){
            throw new RuntimeException("Error serializing data", e);
        }
    }
}
