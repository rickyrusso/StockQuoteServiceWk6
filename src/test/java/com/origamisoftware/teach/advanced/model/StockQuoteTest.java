package com.origamisoftware.teach.advanced.model;

import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import static org.junit.Assert.assertEquals;

/**
 * JUnit test for StockQuote class
 */
public class StockQuoteTest {
    private StockQuote stockQuote;

    @Before
    public void setUp() {
        stockQuote = new StockQuote();
        stockQuote.setPrice(new BigDecimal(100));
        Calendar cal = new GregorianCalendar(2019, 10, 10);
        stockQuote.setDate(cal);
        stockQuote.setSymbol("APPL");
    }

    @Test
    public void testGetPrice() {
        assertEquals("Share price is correct", new BigDecimal(100), stockQuote.getPrice());
    }
    @Test
    public void testGetDate() {
        Calendar cal = new GregorianCalendar(2019, 10, 10);
        assertEquals("Share date is correct", cal, stockQuote.getDate());
    }

    @Test
    public void testGetSymbol() {
        assertEquals("Symbol  is correct", "APPL", stockQuote.getSymbol());
    }
}
