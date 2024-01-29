package processing;

public class StockData {
    private String symbol;
    private double open;
    private double high;
    private double low;
    private double close;
    private int volume;
    private String timestamp; // Assuming a simple string representation for timestamp

    // Constructor, getters, setters, and a toString method
    public StockData(String symbol, double open, double high, double low, double close, int volume, String timestamp) {
        this.symbol = symbol;
        this.open = open;
        this.high = high;
        this.low = low;
        this.close = close;
        this.volume = volume;
        this.timestamp = timestamp;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public double getHigh() {
        return high;
    }

    public void setHigh(double high) {
        this.high = high;
    }

    public double getLow() {
        return low;
    }

    public void setLow(double low) {
        this.low = low;
    }

    @Override
    public String toString() {
        return "StockData{" +
                "symbol='" + symbol + '\'' +
                ", open=" + open +
                ", high=" + high +
                ", low=" + low +
                ", close=" + close +
                ", volume=" + volume +
                ", timestamp='" + timestamp + '\'' +
                '}';
    }
}
