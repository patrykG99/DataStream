package processing;

import serialization.DeserializedStockData;
import serialization.TimeSeriesData;

import java.util.Map;

public class StockAggregate {

    private int totalVolume;
    private double maxPrice;
    private double minPrice;

    public StockAggregate(){
        this.totalVolume = 0;
        this.maxPrice = Double.MIN_VALUE;
        this.minPrice = Double.MAX_VALUE;
    }
    public StockAggregate update(DeserializedStockData stockData) {
        if (stockData != null && stockData.getTimeSeries() != null) {
            Map<String, TimeSeriesData> timeSeriesDataMap = stockData.getTimeSeries().getTimeSeriesDataMap();
            for (TimeSeriesData data : timeSeriesDataMap.values()) {
                this.totalVolume += Integer.parseInt(data.getVolume());
                double high = Double.parseDouble(data.getHigh());
                double low = Double.parseDouble(data.getLow());
                if (high > this.maxPrice) {
                    this.maxPrice = high;
                }
                if (low < this.minPrice) {
                    this.minPrice = low;
                }
            }

        }
        return this;
    }

    @Override
    public String toString() {
        return "StockAggregate{" +
                ", totalVolume=" + totalVolume +
                ", highestHigh=" + maxPrice +
                ", lowestLow=" + minPrice +
                '}';
    }


    public int getTotalVolume() {
        return totalVolume;
    }

    public void setTotalVolume(int totalVolume) {
        this.totalVolume = totalVolume;
    }

    public double getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(double maxPrice) {
        this.maxPrice = maxPrice;
    }

    public double getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(double minPrice) {
        this.minPrice = minPrice;
    }
}
