package org.example.Karat.StockPriceProblem;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public class StockCollection {
    public ArrayList<PriceRecord> priceRecords = new ArrayList<>();
    public Stock stock;

    public StockCollection(Stock stock) {
        this.stock = stock;
    }

    int getNumPriceRecords(){
        return priceRecords.size();
    }

    void addPriceRecord(PriceRecord priceRecord){
        if(!priceRecord.stock.equals(this.stock)){
            throw new IllegalArgumentException("PriceRecord's stock is not the same as stockCollection's");
        }
        priceRecords.add(priceRecord);
    }

    int getMaxPrice(){

        OptionalInt max = priceRecords.stream().mapToInt(x -> x.price).max();
        if(max.isPresent()){
            return max.getAsInt();
        } else {
            return -1;
        }
    }

    int getMinPrice(){
        OptionalInt min = priceRecords.stream().mapToInt(x -> x.price).min();
        if(min.isPresent()){
            return min.getAsInt();
        } else {
            return -1;
        }
    }

    Double getAvgPrice(){
        OptionalDouble average = priceRecords.stream().mapToInt(x -> x.price).average();
        if(average.isPresent()){
            return average.getAsDouble();
        } else {
            return -1.0;
        }
    }

    public List<Object> getBiggestChange(){
        List<PriceRecord> tempList = new ArrayList<>(priceRecords);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        tempList.sort(Comparator.comparing(x->LocalDate.parse(x.date, formatter)));
        int i = 0;
        int j = 1;
        int biggestChange = 0;

        List<LocalDate> dateBound = new ArrayList<>(Arrays.asList(null, null));
        while(i < tempList.size()-1){
            if(biggestChange < (tempList.get(j).price - tempList.get(i).price)){
                biggestChange = tempList.get(j).price - tempList.get(i).price;
                dateBound.set(0,LocalDate.parse(tempList.get(i).date, formatter));
                dateBound.set(1,LocalDate.parse(tempList.get(j).date, formatter));
            }
            i++;
            j++;
        }
        return List.of(biggestChange, dateBound);
    }
}
