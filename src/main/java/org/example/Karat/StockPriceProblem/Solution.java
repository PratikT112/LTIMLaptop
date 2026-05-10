package org.example.Karat.StockPriceProblem;

import org.junit.Assert;

public class Solution {
    public static void main(String[] args) {
        testPriceRecord();
        testStockCollection();
    }
    public static void testPriceRecord() {
        // Test basic PriceRecord functionality
        System.out.println("Running testPriceRecord");
        Stock testStock = new Stock("AAPL", "Apple Inc.");
        PriceRecord testPriceRecord = new PriceRecord(testStock, 100, "2023-07-01");

        Assert.assertEquals(testPriceRecord.stock, testStock);
        Assert.assertEquals(100, testPriceRecord.price);
        Assert.assertEquals("2023-07-01", testPriceRecord.date);

    }

    private static StockCollection makeStockCollection(Stock stock, Object[][] priceData) {
        StockCollection stockCollection = new StockCollection(stock);
        for (Object[] priceRecordData : priceData) {
            PriceRecord priceRecord = new PriceRecord(stock, (int) priceRecordData[0], (String) priceRecordData[1]);
            stockCollection.addPriceRecord(priceRecord);
        }
        return stockCollection;
    }


    public static void testStockCollection() {
        System.out.println("Running testStockCollection");
        // Test basic StockCollection functionality
        Stock testStock = new Stock("AAPL", "Apple Inc.");
        StockCollection stockCollection = new StockCollection(testStock);

        Assert.assertEquals(0, stockCollection.getNumPriceRecords());
        System.out.println("stockCollection.getNumPriceRecords()");
        Assert.assertEquals(-1, stockCollection.getMaxPrice());
        Assert.assertEquals(-1, stockCollection.getMinPrice());
        Assert.assertEquals(-1.0, stockCollection.getAvgPrice(), 0.001);

        /*
         * Price Records: Price: 110 112 90 105 Date: 2023-06-29 2023-07-01 2023-06-28
         * 2023-07-06
         */
        Object[][] priceData = { { 110, "2023-06-29" }, { 125, "2023-07-01" }, { 90, "2023-06-28" },
                { 105, "2023-07-06" } };
        testStock = new Stock("AAPL", "Apple Inc.");
        stockCollection = makeStockCollection(testStock, priceData);

        Assert.assertEquals(priceData.length, stockCollection.getNumPriceRecords());
        Assert.assertEquals(125, stockCollection.getMaxPrice());
        Assert.assertEquals(90, stockCollection.getMinPrice());
//        Assert.assertEquals(104.25, stockCollection.getAvgPrice(), 0.1);
        System.out.println(stockCollection.getBiggestChange());
    }
}


