package com.origamisoftware.teach.advanced.services;

import com.origamisoftware.teach.advanced.model.Person;
import com.origamisoftware.teach.advanced.model.StockQuote;
import com.origamisoftware.teach.advanced.util.DatabaseUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.concurrent.ExecutionException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Unit tests for the DatabaseStockService
 */
public class DatabasePersonServiceTest {

    private PersonService personService;

    private void initDb() throws Exception {
        DatabaseUtils.initializeDatabase(DatabaseUtils.initializationFile);
    }

    @Before
    public void setup() throws Exception {
        initDb();
        personService = ServiceFactory.getPersonServiceInstance();
    }

    @After
    public void tearDown() throws Exception {
        initDb();
    }

    @Test
    public void testGetPerson() throws Exception {
        Person person = personService.getPerson(1);
        assertNotNull(person);
    }

    @Test
    public void testGetStockQuotes() throws Exception {
        Person person = new Person();
        person.setId(1);
        List<StockQuote> stockQuotes = personService.getQuote(person);
    }

}
