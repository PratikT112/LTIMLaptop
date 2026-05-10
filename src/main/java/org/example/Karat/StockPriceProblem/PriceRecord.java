package org.example.Karat.StockPriceProblem;

public class PriceRecord {
    public Stock stock;
    public int price;
    public String date; //Format - "YYYY-MM-DD"

    public PriceRecord(Stock stock, int price, String date) {
        this.stock = stock;
        this.price = price;
        this.date = date;
    }


}
