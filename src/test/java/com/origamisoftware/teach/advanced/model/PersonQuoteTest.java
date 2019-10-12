package com.origamisoftware.teach.advanced.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class PersonQuoteTest {
    private Person person;
    private StockQuote stockQuote;
    private PersonQuote personQuote;

    @Before
    public  void setup(){
        person = new Person();
        person.setId(2);
        person.setFirstName("Joe");
        person.setLastName("Schmo");
        Calendar birdatCal = new GregorianCalendar(1973, 1, 23, 0, 0, 0);
        person.setBirthDate(new Timestamp(birdatCal.getTimeInMillis()));

        stockQuote = new StockQuote();
        stockQuote.setPrice(new BigDecimal(100));
        Calendar quoteCal = new GregorianCalendar(2019, 10, 10);
        stockQuote.setDate(quoteCal);
        stockQuote.setSymbol("APPL");

        personQuote = new PersonQuote();
        personQuote.setId(22);
        personQuote.setPerson(person);
        personQuote.setStockQuote(stockQuote);
    }


    @Test
    public void testPersonQuoteId(){
        assertEquals(22, personQuote.getId());
    }

    @Test
    public void testPersonInstance(){
        assertNotNull(personQuote.getPerson());
    }

    @Test
    public void testQuoteInstance(){
        assertNotNull(personQuote.getStockQuote());
    }

}
