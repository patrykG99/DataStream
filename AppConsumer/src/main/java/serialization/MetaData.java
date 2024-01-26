package serialization;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MetaData {

@JsonProperty("1. Information")
    private String information;
    @JsonProperty("2. Symbol")
    private String symbol;
    @JsonProperty("3. Last Refreshed")
    private String last_refreshed;
    @JsonProperty("4. Interval")
    private String interval;
    @JsonProperty("5. Output Size")
    private String output_size;
    @JsonProperty("6. Time Zone")
    private String timezone;

    public MetaData() {
    }

    @Override
    public String toString() {
        return "MetaData{" +
                "information='" + information + '\'' +
                ", symbol='" + symbol + '\'' +
                ", lastRefreshed='" + last_refreshed + '\'' +
                ", interval='" + interval + '\'' +
                ", outputSize='" + output_size + '\'' +
                ", timeZone='" + timezone + '\'' +
                '}';
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getLast_refreshed() {
        return last_refreshed;
    }

    public void setLast_refreshed(String last_refreshed) {
        this.last_refreshed = last_refreshed;
    }

    public String getInterval() {
        return interval;
    }

    public void setInterval(String interval) {
        this.interval = interval;
    }

    public String getOutput_size() {
        return output_size;
    }

    public void setOutput_size(String output_size) {
        this.output_size = output_size;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }
}
