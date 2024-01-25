package integration;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.sql.Time;
import java.util.Map;
import java.util.Objects;

public class TimeSeriesDeserializer extends JsonDeserializer<TimeSeries> {


    @Override
    public TimeSeries deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        ObjectMapper mapper = (ObjectMapper) jsonParser.getCodec();

        Map<String,TimeSeriesData> map = mapper.readValue(jsonParser,new TypeReference<Map<String, TimeSeriesData>>(){});
        return new TimeSeries(map);







    }
}
