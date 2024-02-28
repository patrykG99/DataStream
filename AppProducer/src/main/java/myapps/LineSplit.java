package myapps;

import com.fasterxml.jackson.core.JsonProcessingException;
import dataGeneration.DataGenerator;
import integration.ApiClient;
import integration.ApiResponse;
import kafka.StockDataProducer;

import java.sql.SQLOutput;


public class LineSplit {
    public static void main(String[] args) throws JsonProcessingException {



        StockDataProducer dataProducer = new StockDataProducer();




        while(true){
            try{
                dataProducer.sendStockData("stock-data","IBM",DataGenerator.convertToJson());
                Thread.sleep(1000);
            }catch (InterruptedException e){
                Thread.currentThread().interrupt();
                System.out.println("Interrupted. Closing producer");
                break;
            }
        }















    }



}
