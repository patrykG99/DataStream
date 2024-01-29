package processing;

import serialization.DeserializedStockData;

public class StockAggregate {

    private int totalVolume;
    private double maxPrice;
    private double minPrice;

    public StockAggregate(){
        this.totalVolume = 0;
        this.maxPrice = Double.MIN_VALUE;
        this.minPrice = Double.MAX_VALUE;
    }
    public StockAggregate update(DeserializedStockData stockData){
        stockData.getTimeSeries().getTimeSeriesDataMap().forEach((k,v) -> this.totalVolume += Integer.parseInt(v.getVolume()));

//        this.maxPrice = Math.max(this.maxPrice, stockData.getHigh());
//        this.minPrice = Math.max(this.minPrice, stockData.getLow());

        return this;
    }





}
