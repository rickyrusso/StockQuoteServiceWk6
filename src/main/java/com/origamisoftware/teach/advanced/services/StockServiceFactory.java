package com.origamisoftware.teach.advanced.services;

import com.origamisoftware.teach.advanced.model.StockQuote;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * A factory that returns a <CODE>StockService</CODE> instance.
 */
public class StockServiceFactory {

    /**
     * Prevent instantiations
     */
    private StockServiceFactory() {}

    /**
     *
     * @return get a <CODE>StockService</CODE> instance
     */
    public static StockService getInstance() {
        return new DatabaseStockService();
    }

}
