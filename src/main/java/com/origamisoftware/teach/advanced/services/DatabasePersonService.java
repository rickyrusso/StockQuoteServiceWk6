package com.origamisoftware.teach.advanced.services;

import com.origamisoftware.teach.advanced.model.Person;
import com.origamisoftware.teach.advanced.model.PersonQuote;
import com.origamisoftware.teach.advanced.model.StockQuote;

import com.origamisoftware.teach.advanced.util.DatabaseUtils;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import javax.print.attribute.standard.MediaSize;
import java.util.ArrayList;
import java.util.List;

public class DatabasePersonService implements PersonService {

    /**
     * Return the current price for a share of stock  for the given symbol
     *
     * @param personId The person with id of the person you want a Person object for.
     * @return a  <CODE>Person</CODE> instance
     * @throws PersonServiceException
     */
    @Override
    public Person getPerson(int personId) throws PersonServiceException {
        Session session =  DatabaseUtils.getSessionFactory().openSession();
        Transaction transaction = null;
        Person person = null;

        try {
            transaction = session.beginTransaction();
            Criteria criteria = session.createCriteria(Person.class);
            criteria.add(Restrictions.eq("id", personId));

            @SuppressWarnings("unchecked")
            List<Person> tempList = criteria.list();
            if(tempList.size() != 1)
                throw new PersonServiceException("There are no person records with the id " + personId);

            person = tempList.get(0);

            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();  // close transaction
            }
        } finally {
            if (transaction != null && transaction.isActive()) {
                transaction.commit();
            }
        }

        return person;
    }

    /**
     * Get a historical list of stock quotes for the provide symbol
     *
     * @param person The person with id of the person you want a Person object for.
     * @return a list of StockQuote instances
     * @throws PersonServiceException
     */
    @Override
    public List<StockQuote> getQuote(Person person) throws PersonServiceException {
        Session session =  DatabaseUtils.getSessionFactory().openSession();
        Transaction transaction = null;
        List<StockQuote> stockQuotes = new ArrayList<StockQuote>();

        try{

            transaction = session.beginTransaction();
            Criteria criteria = session.createCriteria(PersonQuote.class);
            criteria.add(Restrictions.eq("person", person));

            @SuppressWarnings("unchecked")
            List<PersonQuote> tempList = criteria.list();
            if(!tempList.isEmpty()){
                for(PersonQuote pq : tempList){
                    stockQuotes.add(pq.getStockQuote());
                }
            } else{
                throw new PersonServiceException("There are no stocks quotes wit the ID " + 1);
            }

        } catch (HibernateException e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();  // close transaction
            }
        } finally {
            if (transaction != null && transaction.isActive()) {
                transaction.commit();
            }
        }

        return stockQuotes;
    }
}
