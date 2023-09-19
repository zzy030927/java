package com.connection;

import org.junit.Test;

import java.sql.Connection;
import java.sql.Date;
import java.util.List;

public class CustomerDAOImplTest
{
    private CustomersDAOImpl dao = new CustomersDAOImpl();

    @Test
    public void testInsert()  throws Exception
    {
        Connection connection = ConnectionClassFIve.ConnecionClass5();
        Customer cust = new Customer(45, "cxk", "cxk@126.com", new Date(1289462194));
        dao.insert(connection, cust);
        close.closeResource(connection, null);
    }

    @Test
    public void testDeleteById() throws Exception
    {
        Connection connection = ConnectionClassFIve.ConnecionClass5();
        dao.deleteById(connection, 21);
        close.closeResource(connection, null);
    }

    @Test
    public void testUpdateById() throws Exception
    {
        Connection connection = ConnectionClassFIve.ConnecionClass5();
        Customer customer = new Customer(35, "cxk", "cxk@126.com", new Date(98, 7, 2));
        dao.updateById(connection, customer);
        close.closeResource(connection, null);
    }

    @Test
    public void testGetCustomerById() throws Exception
    {
        Connection connection = ConnectionClassFIve.ConnecionClass5();
        Customer customerById = dao.getCustomerById(connection, 35);
        System.out.println(customerById);
        close.closeResource(connection, null);
    }

    @Test
    public void testGetAll() throws Exception
    {
        Connection connection = ConnectionClassFIve.ConnecionClass5();
        List<Customer> all = dao.getAll(connection, 5);
        for(int i = 0; i < all.size(); i++)
            System.out.println(all.get(i));
        close.closeResource(connection, null);
    }

    @Test
    public void testGetCount() throws Exception
    {
        Connection connection = ConnectionClassFIve.ConnecionClass5();
        Long count = dao.getCount(connection);
        System.out.println(count);
        close.closeResource(connection, null);
    }

    @Test
    public void testGetMaxBirth() throws Exception
    {
        Connection connection = ConnectionClassFIve.ConnecionClass5();
        Date maxBirth = dao.getMaxBirth(connection);
        System.out.println(maxBirth);
        close.closeResource(connection, null);
    }
}
