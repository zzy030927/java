package com.dbutils;

import com.connection.Customer;
import com.connection.close;
import com.connectionPool.DruidTest;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.Test;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class QueryRunnerTest
{
    @Test
    public void testInsert() throws Exception {
        QueryRunner runner = new QueryRunner();
        Connection connection = DruidTest.getDruidConnection();
        String sql = "INSERT INTO customers(name,email,birth) values(?,?,?)";
        // CURD 方法重载的方法有好几个，如果传入的参数有 Connection,那么它就不是一个单独的事务，不会在方法内部关闭连接导致数据不能回滚。
        // 如果没有传入 Connection,那么它就是一个单独的事务，在方法内部创建连接，程序运行完成后关闭连接。
        runner.update(connection,sql,"kunGe","kun@126.com","1997-08-02");
        close.closeResource(connection,null);
    }
    @Test
    public void ManyResult() throws Exception {
        QueryRunner runner = new QueryRunner();
        Connection connection = DruidTest.getDruidConnection();
        String sql = "SELECT id,name,email,birth FROM customers WHERE id < ?";
        BeanListHandler<Customer> handler = new BeanListHandler<>(Customer.class);
        List<Customer> resultSet = runner.query(connection, sql, handler, 37);
        for(int i = 0; i < resultSet.size(); i++)
            System.out.println(resultSet.get(i));
        close.closeResource(connection,null);
    }
    @Test
    public void SpecificResult() throws Exception{
        QueryRunner runner = new QueryRunner();
        Connection connection = DruidTest.getDruidConnection();
        String sql = "SELECT COUNT(*) FROM customers WHERE id < ?";
        ScalarHandler handler = new ScalarHandler();
        Object query = runner.query(connection, sql, handler, 37);
        System.out.println(query);
        DbUtils.closeQuietly(connection);
        // DbUtils.closeQuietly(ps);
        // DbUtils.closeQuietly(rs);
    }
    @Test
    public void definedSQL() throws Exception
    {
        QueryRunner runner = new QueryRunner();
        Connection connection = DruidTest.getDruidConnection();
        String sql = "SELECT id,name,email,birth FROM customers WHERE id = ?";
        ResultSetHandler<Customer> handler = new ResultSetHandler<Customer>() {     // 实现匿名类
            @Override
            public Customer handle(ResultSet rs) throws SQLException {
                Customer customer = new Customer();
                if(rs.next())
                {
                    int id = rs.getInt("id");
                    String name = rs.getString("name");
                    String email = rs.getString("email");
                    Date birth = rs.getDate("birth");
                    customer = new Customer(id, name, email, birth);
                }
                return customer;
            }
        };
        Customer result = runner.query(connection, sql, handler, 37);
        System.out.println(result);
        DbUtils.closeQuietly(connection);
    }
}
