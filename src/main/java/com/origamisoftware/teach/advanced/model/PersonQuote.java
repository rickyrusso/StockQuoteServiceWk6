package com.origamisoftware.teach.advanced.model;

import javax.persistence.*;

@Entity
@Table(name="person_quote")
public class PersonQuote {
    private int id;
    private Person person;
    private StockQuote stockQuote;

    /**
     * Primary Key - Unique ID for a particular row in the PersonQuote table.
     *
     * @return an integer value
     */
    @Id
    @Column(name = "ID", nullable = false, insertable = true, updatable = true)
    public int getId() {
        return id;
    }

    /**
     * Set the unique ID for a particular row in the PersonQuote table.
     * This method should not be called by client code. The value is managed in internally.
     *
     * @param id a unique value.
     */
    public void setId(int id) {
        this.id = id;
    }


    /**
     *
     * @return get the Person associated with this Quote
     */
    @ManyToOne
    @JoinColumn(name = "person_id", referencedColumnName = "ID", nullable = false)
    public Person getPerson() {
        return person;
    }

    /**
     * Specify the Person associated with the Quote.
     *
     * @param person a person instance
     */
    public void setPerson(Person person) {
        this.person = person;
    }




    /**
     *
     * @return get the Quote associated with this Quote
     */
    @ManyToOne
    @JoinColumn(name = "quote_id", referencedColumnName = "ID", nullable = false)
    public StockQuote getStockQuote() {
        return this.stockQuote;
    }

    /**
     * Specify the Person associated with the Quote.
     *
     * @param stockQuote a person instance
     */
    public void setStockQuote(StockQuote stockQuote) {
        this.stockQuote = stockQuote;
    }



    @Override
    public int hashCode() {
        int result = id;

        result = 31 * result + person.hashCode();
        result = 31 * result + stockQuote.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "PersonQuote{" +
                "id=" + id +
                ", personId='" + person.getId() + '\'' +
                ", quoteSymbol='" + stockQuote.getSymbol() + '\'' +
                '}';
    }
}
