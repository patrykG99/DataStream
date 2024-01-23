package integration;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

public class ApiResponse {
    @JsonProperty("Meta Data")
    private MetaData metaData;

    @JsonProperty("Time Series (5min)")
    private TimeSeries timeSeries;

    public ApiResponse() {
    }

    public MetaData getMetaData() {
        return metaData;
    }

    public TimeSeries getTimeSeries() {
        return timeSeries;
    }

    public void setMetaData(MetaData metaData) {
        this.metaData = metaData;
    }

    public void setTimeSeries(TimeSeries timeSeries) {
        this.timeSeries = timeSeries;
    }
}
