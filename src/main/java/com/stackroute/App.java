package com.stackroute;

import com.stackroute.model.Customer;
import com.stackroute.service.DemoBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )

    {
        ApplicationContext context = new ClassPathXmlApplicationContext("file:src/main/java/applicationcontext.xml");
        DemoBean demo = (DemoBean) context.getBean("db");
        // Inserting Data into customer table..
        demo.insertCustomer(1, "chandra", "Hyd");


        // Selecting data from customer table
        Customer customer = demo.selectCustomer(1);
        System.out.println("Inserted Customer Name : " + customer.getCustomerName());
        // updating customer data in customer table..
        Customer customer2 = new Customer();
        customer2.setCustomerId(1);
        customer2.setCustomerAddress("Vizag");
        customer2.setCustomerName("shekhar");
        demo.updateCustomer(customer2);
        // Deleting customer data from customer table..
        int count = demo.deleteCustomer(1);
            System.out.println(count > 0 ? "Deleted Successfully" : "No Records found");

    }


}

