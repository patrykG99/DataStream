package serialization;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DeserializedStockData {

    @JsonProperty("Meta Data")
    private MetaData metaData;

    @JsonProperty("Time Series (5min)")
    private TimeSeries timeSeries;

    public DeserializedStockData() {
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

    public void update(DeserializedStockData newData) {
        if (newData != null) {
            // Assuming you want to update only the time series data
            // and keep the meta data as is.
            // Adjust this logic according to your specific needs.
            if (newData.getTimeSeries() != null) {
                this.timeSeries = newData.getTimeSeries();
            }
        }
    }

    @Override
    public String toString() {
        return "DeserializedStockData{" +
                "metaData=" + (metaData != null ? metaData.toString() : "null") +
                ", timeSeries=" + (timeSeries != null ? timeSeries.toString() : "null") +
                '}';
    }



}
