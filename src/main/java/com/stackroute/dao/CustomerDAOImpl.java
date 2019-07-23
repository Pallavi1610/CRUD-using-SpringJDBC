package com.stackroute.dao;

import com.stackroute.model.Customer;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerDAOImpl implements CustomerDAO {
    private JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public Customer selectCustomer(int customerId) {
        final Customer customer=new Customer();
        return jdbcTemplate.query("SELECT * From customer", new ResultSetExtractor<Customer>() {
            @Override
            public Customer extractData(ResultSet resultSet) throws SQLException, DataAccessException {


                while(resultSet.next())
                {
                    customer.setCustomerId(resultSet.getInt(1));
                    customer.setCustomerName(resultSet.getString(2));
                    customer.setCustomerAddress(resultSet.getString(3));

                }

                return  customer;
            }
        });
    }

    @Override
    public int insert(Customer c) {
        int custId=c.getCustomerId();
        String name=c.getCustomerName();
        String address=c.getCustomerAddress();
        int rows=jdbcTemplate.update("insert into customer values(?,?,?)",custId, name,address);
        return rows;
    }

    @Override
    public int deleteCustomer(int customerId) {
        String query = "DELETE from customer where custid=?";
        return jdbcTemplate.update(query, new Object[] { Integer.valueOf(customerId) });

    }

    @Override
    public void updateCustomer(Customer customer) {
        String query="UPDATE customer set custname=?,city=? where custid=?";
        jdbcTemplate.update(query,
                new Object[] {
                        customer.getCustomerName(),customer.getCustomerAddress(), Integer.valueOf(customer.getCustomerId())
                });
    }
}
