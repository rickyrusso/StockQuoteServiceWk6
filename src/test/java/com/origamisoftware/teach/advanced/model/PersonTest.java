package com.origamisoftware.teach.advanced.model;

import org.junit.Before;
import org.junit.Test;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.GregorianCalendar;

import static org.junit.Assert.assertEquals;

public class PersonTest {
    private Person person;

    @Before
    public void setup() {
        person = new Person();
        person.setId(2);
        person.setFirstName("Joe");
        person.setLastName("Schmo");
        Calendar cal = new GregorianCalendar(1973, 1, 23, 0, 0, 0);
        person.setBirthDate(new Timestamp(cal.getTimeInMillis()));
    }

    @Test
    public void testGetFirstName(){
        assertEquals("First name is correct", "Joe", person.getFirstName());
    }

    @Test
    public void testGetLastName(){
        assertEquals("Last name is correct", "Schmo", person.getLastName());
    }

    @Test
    public void testBirthDate(){
        Calendar expectedCal = new GregorianCalendar(1973, 1, 23, 0, 0, 0);
        assertEquals("Birthdate is correct", expectedCal.getTimeInMillis(), person.getBirthDate().getTime());
    }
}
