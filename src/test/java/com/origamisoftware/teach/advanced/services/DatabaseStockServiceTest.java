package com.origamisoftware.teach.advanced.services;

import com.origamisoftware.teach.advanced.model.StockQuote;
import com.origamisoftware.teach.advanced.util.DatabaseUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Unit tests for the DatabaseStockService
 */
public class DatabaseStockServiceTest {

    private void initDb() throws Exception {
        DatabaseUtils.initializeDatabase(DatabaseUtils.initializationFile);
    }

    @Before
    public void setup() throws Exception {
        initDb();
    }

    @After
    public void tearDown() throws Exception {
        initDb();
    }

    @Test
    public void testGetQuote() throws Exception {
        DatabaseStockService databaseStockService = new DatabaseStockService();
        String symbol = "APPL";
        StockQuote stockQuote = databaseStockService.getQuote(symbol);
        assertNotNull("Verify we can get a stock quote from the db", stockQuote);
        assertEquals("Make sure the symbols match", symbol, stockQuote.getSymbol());
    }
}
