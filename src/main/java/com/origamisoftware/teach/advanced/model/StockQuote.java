package com.origamisoftware.teach.advanced.model;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * A container class that contains stock data.
 */
public class StockQuote extends StockData  {
    private BigDecimal price;
    private Calendar date;
    private String symbol;

    /**
     * Create a new instance of a StockQuote.
     *
     * @param price  the share price for the given date
     * @param date   the date of the share price
     * @param symbol the stock symbol.
     */
    public StockQuote(BigDecimal price, Calendar date, String symbol) {
        super();
        this.price = price;
        this.date = date;
        this.symbol = symbol;
    }

    /**
     * @return Get the share price for the given date.
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * @return The date of the share price
     */
    public Calendar getDate() {
        return date;
    }

    /**
     * @return The stock symbol.
     */
    public String getSymbol() {
        return symbol;
    }

    @Override
    public String toString() {
        return String.format("StockQuote{Symbol=%s, Price=%s, Date=%s}", price, simpleDateFormat.format(date.getTime()), symbol);
    }
}
