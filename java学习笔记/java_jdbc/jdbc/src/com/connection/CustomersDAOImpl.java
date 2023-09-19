package com.connection;


import org.junit.Test;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.sql.Date;
import java.util.List;

public class CustomersDAOImpl extends BaseDAO<Customer> implements CustomerDAO  //运用了通配符上界， BaseDAO和 他的子类只能传入 Customer的类
{

    public void insert(Connection connection, Customer cust) throws Exception {
        String sql = "INSERT INTO customers(name,email,birth) VALUES(?,?,?)";
        OptimizeUniverseDML(connection, sql, cust.getName(), cust.getEmail(), cust.getDate());
    }

    public void deleteById(Connection connection, int id) throws Exception {
        String sql = "DELETE FROM customers WHERE id = ?";
        OptimizeUniverseDML(connection, sql, id);
    }

    public void updateById(Connection connection, Customer cust) throws Exception {
        String sql = "UPDATE customers SET name = ?,email = ?,birth = ? WHERE id = ?";
        OptimizeUniverseDML(connection, sql, cust.getName(), cust.getEmail(), cust.getDate(), cust.getId());
    }

    public Customer getCustomerById(Connection connection, int id) throws Exception {
        String sql = "SELECT id,name,birth FROM customers WHERE id = ?";
        Customer customer = UniverseSelectSQL(connection, sql, id);
        return customer;
    }

    public List<Customer> getAll(Connection connection, int id) throws Exception {
        String sql = "SELECT id,name,birth,email FROM customers WHERE id > ?";
        List<Customer> customers = SelectManyResult(connection, sql, id);
        return customers;
    }

    public Long getCount(Connection connection) throws Exception {
        String sql = "SELECT COUNT(*) FROM customers";
        return getValue(connection,sql);
    }

    public Date getMaxBirth(Connection connection) throws Exception {
        String sql = "SELECT MAX(birth) FROM customers";
        return getValue(connection, sql);
    }
}
