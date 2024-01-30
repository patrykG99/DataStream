package dataGeneration;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

public class DataGenerator {
    public static Map<String, Object> generateStockDataJson() {

        StockMetaData metaData = new StockMetaData("Intraday (5min) open, high, low, close prices and volume",
                "IBM",
                LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME),
                "5min",
                "Compact",
                "US/Eastern");


        Map<String, TimeSeriesDataGen> timeSeries = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            LocalDateTime timestamp = LocalDateTime.now().minusMinutes(5 * i);
            String formattedTimestamp = timestamp.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            double open = Math.random() * 100;
            double low = open - Math.random() * 10;
            if(low < 0)
                low *= -1;
            TimeSeriesDataGen data = new TimeSeriesDataGen(
                    String.format(Locale.ENGLISH,"%.4f",open),String.format(Locale.ENGLISH,"%.4f",open + Math.random() * 10) ,String.format(Locale.ENGLISH,"%.4f",low),String.format(Locale.ENGLISH,"%.4f",low + Math.random() * 10), "" + (int) (Math.random() * 1000)
            );
            timeSeries.put(formattedTimestamp, data);
        }


        Map<String, Object> result = new LinkedHashMap<>();
        result.put("Meta Data", metaData);
        result.put("Time Series (5min)", timeSeries);


        return result;
    }

    public static String convertToJson() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        String jsonString = mapper.writeValueAsString(DataGenerator.generateStockDataJson());
        return  jsonString;
    }
}
