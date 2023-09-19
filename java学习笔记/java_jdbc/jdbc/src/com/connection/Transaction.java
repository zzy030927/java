package com.connection;
import java.sql.*;


/*
 * 数据库事务:
 * 事务：一组逻辑操作单元，是数据从一组状态变换到另一种状态
 *      一组逻辑操作单元：一个或多个 DML 操作，多个 DML 操作之间有关联，称这多个 DML 操作为 一组逻辑单元
 * 事务处理的原则： 需要保证事务都作为一个工作单元来执行，即使除了故障，都不能改变这种执行方式，
 *              要么所有数据都被提交 commit，数据被永久保存下来，注意：数据一旦提交，就不可回滚
 *              要么数据库放弃所有的操作，同时数据库 rollback 到最初的状态。
 *  DDL：数据库定义语言（ ALTER\CREATE\DROP\TRUNCATE ）
 *  DML：数据库操作语言（ INSERT\UPDATE\DELETE ）
 *  DDL操作一旦执行，都会自动提交
 *  DML默认情况下，一旦执行，会自动提交 -> set autocommit = false 取消自动提交，这个操作对 DDL 失效
 *  默认在关闭连接时会自动提交之前执行操作更新的数据
 */

// 事务的 ACID 属性
// 1.原子性：事务是一个不可分割的工作单位，要么都发生，要么都不发生
// 2.一致性：事务必须从一个一致性状态变换为另一个一致性状态
// 3.隔离性：一个事务给另一个事务不能产生干扰，一个事务内操作的数据另一个事务是不影响的，并发执行的各个事务之间互不影响
// 4.持久性：一个事务一旦被提交，那么它对数据库的改变是永久性的，接下来的其他操作和数据库故障不会对其产生任何影响

// 数据库的并发问题：对于多个运行的事务，当这些事务访问数据库相同的数据时，如果没有采用必要的隔离机制，就会导致各种并发问题：
// 1.脏读：对于两个事务 T1,T2，如果 T1读取了已经被 T2更新但是还没有提交的字段，之后，若 T2 回滚，T1 读取的数据是临时且无效的，这个问题是必须要被解决的。
// 2.不可重复读：对于两个事务 T1,T2,如果 T1 读取了一个字段，然后 T2 更新了该字段，之后 T1 再次读取该字段时发现该字段的值已经被改变。脏读这个问题是可以被接受的
// 3.幻读：对于两个事务 T1,T2, T1从一个表中读取了一个字段，然后 T2 插入了一些新的行，之后，如果 T1 再次查询这个表时会发现表多处几行数据，幻读这个问题是可以被接受的。

// 四种隔离级别：
// 1. READ UNCOMMITTED（读未提交数据）  脏读、不可重复读、幻读都为解决
// 2. READ COMMITTED  （读已提交数据）  解决了脏读
// 3. REPEATABLE READ （可重复读）     解决了脏读、不可重复读，当 T2 更新完数据后，如果 T1 还未关闭连接，那么 T1 读到的还是原来的数据
// 4. SERIALIZABLE    （串行化）       解决了脏读、不可重复读、幻读，当 T2 插入完数据后，如果 T1 还未关闭连接，那么 T1 查到的还是原来的数据

public class Transaction
{
    public static void transaction() throws Exception  {
        Connection connection;
        connection = ConnectionClassFIve.ConnecionClass5();
        try
        {
            // 取消数据自动提交功能
            connection.setAutoCommit(false);
            String sql = "UPDATE user_table SET balance = balance + 100 WHERE user = ?";
            String name = "AA";
            String sql1 = "UPDATE user_table SET balance = balance - 100 WHERE user = ?";
            String name1 = "BB";
            preparedStatement.OptimizeUniverseDML(connection, sql, name);
            preparedStatement.OptimizeUniverseDML(connection, sql1, name1);
            //在最后提交数据
            connection.commit();
        }
        catch(Exception e)  // 出现异常，转到 catch
        {
            // 如果出现异常，回滚数据
            connection.rollback();
            e.printStackTrace();
        }
        finally
        {
            connection.setAutoCommit(true);
            close.closeResource(connection, null);
        }
    }
}
