package com.stackroute.service;

import com.stackroute.dao.CustomerDAO;
import com.stackroute.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;

public class DemoBean {
    @Autowired
    private CustomerDAO customerDAO;

    public void setCustomerDAO(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;

    }
    public void insertCustomer(int cid,String custName,String addr)
    {
        Customer customer=new Customer();
        customer.setCustomerId(cid);
        customer.setCustomerName(custName);
        customer.setCustomerAddress(addr);
        int res=customerDAO.insert(customer);
        System.out.println(res+ ": Records inserted");
    }
    public int deleteCustomer(int cid)
    {
        return customerDAO.deleteCustomer(cid);
    }
    public Customer selectCustomer(int customerId)
    {
        return customerDAO.selectCustomer(customerId);
    }
    public void updateCustomer(Customer customer)
    {
        customerDAO.updateCustomer(customer);
    }
}

