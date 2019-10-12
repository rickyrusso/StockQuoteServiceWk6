package com.origamisoftware.teach.advanced.services;

import com.origamisoftware.teach.advanced.model.Person;
import com.origamisoftware.teach.advanced.model.StockQuote;

import java.util.Calendar;
import java.util.List;

/**
 * This API describes how to get Person and PersonStockQuotes data from an external resource.
 */
public interface PersonService {

    /**
     * Return the current price for a share of stock  for the given symbol
     *
     * @param personId  The person with id of the person you want a Person object for.
     * @return a  <CODE>Person</CODE> instance
     * @throws PersonServiceException
     */
    Person getPerson(int personId) throws PersonServiceException;

    /**
     * Get a historical list of stock quotes for the provide symbol
     *
     * @param person  The person with id of the person you want a Person object for.
     * @return a list of StockQuote instances
     * @throws   PersonServiceException
     */
    List<StockQuote> getQuote(Person person) throws PersonServiceException;

}
