package com.origamisoftware.teach.advanced.services;

import com.origamisoftware.teach.advanced.model.StockQuote;
import com.origamisoftware.teach.advanced.util.DatabaseConnectionException;
import com.origamisoftware.teach.advanced.util.DatabaseUtils;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * An implementation of the StockService interface that gets
 * stock data from a database.
 */
public class DatabaseStockService implements StockService {

    /**
     * Return the current price for a share of stock  for the given symbol
     *
     * @param symbol the stock symbol of the company you want a quote for.
     *               e.g. APPL for APPLE
     * @return a  <CODE>BigDecimal</CODE> instance
     * @throws StockServiceException if using the service generates an exception.
     *                               If this happens, trying the service may work, depending on the actual cause of the
     *                               error.
     */
    @Override
    public StockQuote getQuote(String symbol) throws StockServiceException {
        StockQuote stockQuote = null;

        try {
            Connection connection = DatabaseUtils.getConnection();
            String sql = "select * from quotes where symbol = ? ORDER BY time desc LIMIT 1";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, symbol);

            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()) {
                String symbolValue = resultSet.getString("symbol");
                Calendar calendarDate = new GregorianCalendar();
                calendarDate.setTime(resultSet.getDate("time"));
                BigDecimal price = resultSet.getBigDecimal("price");
                //stockQuote = new StockQuote(price, calendarDate, symbolValue);
            } else {
                throw new StockServiceException("There is no stock data for:" + symbol);
            }

        } catch (DatabaseConnectionException | SQLException exception) {
            throw new StockServiceException(exception.getMessage(), exception);
        }

        return stockQuote;
    }

    /**
     * Get a historical list of stock quotes for the provide symbol
     *
     * @param symbol the stock symbol to search for
     * @param from   the date of the first stock quote
     * @param until  the date of the last stock quote
     * @return a list of StockQuote instances
     * @throws   StockServiceException if using the service generates an exception.
     * If this happens, trying the service may work, depending on the actual cause of the
     * error.
     */
    @Override
    public List<StockQuote> getQuote(String symbol, Calendar from, Calendar until) throws StockServiceException {
        List<StockQuote> stockQuotes = null;

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = DatabaseUtils.getConnection();
            String sql = "select * from quotes where Symbol = ? AND time > ? AND time < (? + INTERVAL 1 DAY) ;";
            statement = connection.prepareStatement(sql);
            statement.setString(1, symbol);
            java.sql.Date fromSqlDate = new java.sql.Date(from.getTime().getTime());
            java.sql.Date untilSqlDate = new java.sql.Date(until.getTime().getTime());
            statement.setDate(2, fromSqlDate);
            statement.setDate(3, untilSqlDate);

            resultSet = statement.executeQuery();
            stockQuotes = new ArrayList<StockQuote>(resultSet.getFetchSize());
            while(resultSet.next()) {
                String symbolValue = resultSet.getString("symbol");
                Calendar calendarDate = new GregorianCalendar();
                calendarDate.setTime(resultSet.getDate("time"));
                BigDecimal price = resultSet.getBigDecimal("price");
                //stockQuotes.add(new StockQuote(price, calendarDate, symbolValue));
            }

        } catch (DatabaseConnectionException | SQLException exception) {
            throw new StockServiceException(exception.getMessage(), exception);
        }
        finally {
            closeDBObjects(connection, statement, resultSet);
        }
        if (stockQuotes.isEmpty()) {
            throw new StockServiceException("There is no stock data for:" + symbol);
        }
        return stockQuotes;
    }


    private void closeDBObjects(Connection connection, PreparedStatement statement, ResultSet resultSet) {
        try {
            if (connection != null){
                connection.close();
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        try {
            if (statement != null){
                statement.close();
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        try {
            if (resultSet != null){
                resultSet.close();
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }
}
