package org.example.Karat.StockPriceProblem;

import java.util.Objects;

public class Stock {
    public String symbol;
    public String name;

    public Stock(String symbol, String name) {
        this.symbol = symbol;
        this.name = name;
    }

    @Override
    public int hashCode() {
        return Objects.hash(symbol, name);
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(obj == null || getClass() != obj.getClass()) return false;
        Stock that = (Stock) obj;
        return symbol.equals(that.symbol) && name.equals(that.name);
    }
}
