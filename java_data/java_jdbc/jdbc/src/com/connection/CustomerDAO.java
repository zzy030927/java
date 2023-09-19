package com.connection;

import java.sql.*;
import java.util.List;

/*
    此接口用于规范针对于 customers 表的常用操作,这个接口只针对于 Customer 表，对 Customer 表进行一些具体的操作，而 BaseDAO 类是所有表都可以进行的操作
    接口用于给出表的具体操作，而 BaseDAO 表给出的是一些通用的操作
 */
public interface CustomerDAO
{
    void insert(Connection connection, Customer cust) throws Exception;
    void deleteById(Connection connection, int id) throws Exception;
    // 针对内存中的 cust对象，去修改数据表中指定的记录
    void updateById(Connection connection, Customer cust) throws Exception;
    Customer getCustomerById(Connection connection, int id) throws Exception;
    // 查询表中所有记录构成的集合
    List<Customer> getAll(Connection connection, int id) throws Exception;
    // 返回数据表中的条目数
    Long getCount(Connection connection) throws Exception;
    // 返回数据表中最大的生日
    Date getMaxBirth(Connection connection) throws Exception;
}
