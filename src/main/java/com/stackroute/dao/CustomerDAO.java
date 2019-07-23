package com.stackroute.dao;

import com.stackroute.model.Customer;

public interface CustomerDAO {
    Customer selectCustomer(int customerId);
    int insert(Customer c);
    int deleteCustomer(int customerId);
    void updateCustomer(Customer customer);
}
