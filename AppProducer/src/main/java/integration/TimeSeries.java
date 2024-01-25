package integration;



import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.Map;

@JsonDeserialize(using = TimeSeriesDeserializer.class)
public class TimeSeries {

    private Map<String, TimeSeriesData> timeSeriesDataMap;

    public TimeSeries() {
    }

    public TimeSeries(Map<String, TimeSeriesData> timeSeriesDataMap) {
        this.timeSeriesDataMap = timeSeriesDataMap;
    }
    @JsonAnyGetter
    public Map<String, TimeSeriesData> getTimeSeriesDataMap() {
        return timeSeriesDataMap;
    }
    @JsonAnySetter
    public void setTimeSeriesDataMap(Map<String, TimeSeriesData> timeSeriesDataMap) {
        this.timeSeriesDataMap = timeSeriesDataMap;
    }
}


