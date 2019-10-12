package com.origamisoftware.teach.advanced.model;

import org.junit.Before;
import org.junit.Test;

import java.util.Date;
import java.util.GregorianCalendar;

import static org.junit.Assert.assertEquals;

/**
 * Unit test for StockQuery Class
 */
public class StockQueryTest {
    private StockQuery stockQuery;

    @Before
    public  void setup() throws Exception{
        stockQuery = new StockQuery("APPL","11/5/2019","11/10/2019");
    }

    @Test
    public void testSymbol() {
        assertEquals("Verify symbol", "APPL", stockQuery.getSymbol());
    }

    @Test
    public void testFrom() {
        Date expected = new GregorianCalendar(2019, 10, 5, 0, 0, 0).getTime();
        assertEquals("Verify from", expected, stockQuery.getFrom().getTime());
    }

    @Test
    public void testUntil() {
        Date expected = new GregorianCalendar(2019, 10, 10, 0, 0, 0).getTime();
        assertEquals("Verify until", expected, stockQuery.getUntil().getTime());
    }

}
