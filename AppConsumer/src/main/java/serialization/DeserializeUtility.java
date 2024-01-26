package serialization;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import kafka.StockDataConsumer;

public class DeserializeUtility {
    public static DeserializedStockData  deserializeData(String stockData){

        ObjectMapper mapper = new ObjectMapper();

        try {
            return mapper.readValue(stockData, DeserializedStockData.class);
        }catch (JsonProcessingException e){
            System.out.println("JSON Processing Error: " + e.getMessage());
        }



    return null;

    }
}
