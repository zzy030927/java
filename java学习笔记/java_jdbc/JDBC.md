<a name="oUbQP"></a>
## 一、JDBC概述
<a name="YONuD"></a>
#### 1.1  JDBC概述
:::info

   - JDBC是java访问数据库的基石，JDBC可以直接访问数据库，jdo\mybaits只是更好的封装了jdbc
   - JDBC是一个独立于数据库管理系统、通用的SQL数据库存取和操作的公共接口(API)，定义了用来访问数据库的标准java类库，可以更加方便的访问数据库
:::
<a name="TyfJ4"></a>
##### 1.1.1 java与SQL对应数据类型转换表
| <a name="u4Fya"></a>
#####                        JAVA类型
 | **                            SQL类型** |
| --- | --- |
|                        boolean |                             BIT |
|                        byte |                             TINYINT |
|                        short |                             SMALLINT |
|                        int |                             INTEGER |
|                        long  |                             BIGINT |
|                        String |          CHAR,VARCHAER,LONGVARCAHR |


<a name="wn4ic"></a>
#### 1.2  Java访问数据库的方式
:::info

   -  java->JDBC接口->JDBC驱动->数据库
:::
<a name="Qxim3"></a>
#### 1.3  JDBC体系结构
:::info

   - JDBC接口(API)包括两个层次：
      - 面向应用的API：java api，抽象接口，供应用程序开发人员使用（连接数据库，执行SQL语句，获得结果）。
      - 面向数据库的API：java  driver  api，供应开发商开发数据库驱动程序应用
:::
<a name="YgAHW"></a>
#### 1.4  JDBC程序编写步骤
:::info

      1. 导入java.sql包
      2. 加载数据库的驱动（例如：MySQL、Orcal）
      3. 获取数据库的连接（创建Connection对象）	Connection :连接
      4. 用Statement对象对数据表增删改查操作		Statement :声明
      5. 执行SQL语句
      6. 查出的结果称为 Result对象，使用 Result对象	Result :结果
      7. 使用完后，关闭 Result对象、关闭Statement对象、关闭Connection对象
      8. 结束
:::
<a name="eUj1x"></a>
##  二、获取数据库连接
<a name="AIcG8"></a>
####  获取数据库连接	
链接方式
1.  导入 java.sql包，import java.sql.*;
2.  加载数据库的驱动，在工程文件夹下创建一个 direcotry 文件夹，也就是目录文件夹，名字声明为 lib，导入数据库驱动，是一个 jar文件，jar文件里聚合了大量的Java类文件，相关的元数据和资源到一个文件
3. ** **获取数据库连接，创建 Connection对象
4. 数据库连接方式
```java
	// 注意：数据库驱动版本过低或者过高都会导致数据库连接异常
	Driver driver = new com.mysql.cj.jdbc.Driver();
	//      Driver 接口用于连接数据库，创建一个mysql驱动对象，并把它赋值给 driver
	//	    注意要写新的驱动地址，不要写成 com.mysql.jdbc.Driver(),这是5.0版本的驱动地址;
    //      Driver 连接数据库接口的对象，对这个对象进行实例化
    //      idea : Ctrl + H 查看实现类
    
    String url = "jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf-8&&allowPublicKeyRetrieval=true&useSSL=false&serverTimezone = GMT";
    
    //      URL 为 要连接哪个数据库, 意义为 用 jdbc链接 mysql 数据库，连接的主机（ip）是localhost
    //      端口号是 3306，链接的表是 localhost 中的 test 数据库
    //		? 后面写参数
	//      useUnicode = true&characterEncoding = utf-8 作用是设置编码解码格式
    //      useSSL = false; 网址:https://blog.csdn.net/weixin_46644575/article/details/117003617?ops_request_misc=%257B%2522request%255Fid%2522%253A%2522167973667916800197064678%2522%252C%2522scm%2522%253A%252220140713.130102334..%2522%257D&request_id=167973667916800197064678&biz_id=0&utm_medium=distribute.pc_search_result.none-task-blog-2~all~top_positive~default-1-117003617-null-null.142^v76^insert_down38,201^v4^add_ask,239^v2^insert_chatgpt&utm_term=usessl%3Dfalse&spm=1018.2226.3001.4187
    //      allowPublicKeyRetrieval=true 允许客户端从服务器获取公钥。
    //      serverTimezone = GMT，无论是使用5.#数据库还是8.#版本数据库，
    //      只要jdbc驱动使用的是8.#那么我们就需要考虑数据库时区问题，否则就会报时区错误
    //      所以要加 serverTimezone = GMT,这是设置时区的作用
    
    Properties info = new Properties();
    info.setProperty("user","root");
    info.setProperty("password","zzy0927");
    //      将用户名和密码封装在 Properties中
    
    Connection connection = driver.connect(url,info);
    //      Driver 接口中的 connect 方法，用于连接数据库，
    //      里面的两个参数 String类型的 url 与 Properties类型的 info
    //      并且把这个连接完成的数据给 Connection 对象。
    
    System.out.println("链接成功");
    System.out.println(connection);
```
```java
// 1.用反射方式接受驱动地址并且获取 Driver类对象
Class clazz = Class.forName("com.mysql.cj.jdbc.Driver");
// 由于 com.mysql.cj.jdbc.Driver 为第三方的 API,所以我们用到反射
// 好处是避免了第三方 API的出现
Driver driver = (Driver) clazz.newInstance();

// 2.提供要连接的数据库
String url = "jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf-8&allowPublicKeyRetrieval=true&useSSL=false&serverTimezone = UTC";
Properties info = new Properties();
info.setProperty("user","root");
info.setProperty("password","zzy0927");
Connection connection = driver.connect(url, info);
System.out.println("连接成功二");
System.out.println(connection);
```
```java
// 使用 DriverManager类 替代 Driver

// 用反射获取 Driver 的实现类对象
Class clazz = Class.forName("com.mysql.cj.jdbc.Driver");
Driver driver = (Driver) clazz.newInstance();
String url = "jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf-8&allowPublicKeyRetrieval=true&useSSL=false&serverTimezone = UTC";
String user = "root";
String password = "zzy0927";
// DriverManager类中有一个 registerDriver方法用于注册驱动
DriverManager.registerDriver(driver);
// DriverManager类中有一个 getConnection方法获取连接
Connection connection = DriverManager.getConnection(url, user, password);
System.out.println("连接成功三");
System.out.println(connection);
```
```java
String url = "jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf-8&allowPublicKeyRetrieval=true&useSSL=false&serverTimezone = UTC";
String user = "root";
String password = "zzy0927";
//      方法四对方法三进行优化，mysql 帮忙注册，不用自己去 registerDriver 注册
//      驱动 Driver接口 中有一个 static 静态代码块，它随着类的加载而执行，这个静态代码块注册驱动
Class.forName("com.mysql.cj.jdbc.Driver");
//        Driver driver = (Driver) clazz.newInstance();
// 注册驱动
//        DriverManager.registerDriver(driver);
Connection connection = DriverManager.getConnection(url, user, password);
System.out.println("连接成功四");
System.out.println(connection);
```
```java
// 第五种连接方式
//下面三行作用为把 jdbc.properties 中的数据读取到 pro 中。
InputStream is = new FileInputStream("src/com/connection/jdbc.properties");
Properties pro =new Properties();
pro.load(is);

// 获取 jdbc.properties 中的数据
String user = pro.getProperty("user");
String password = pro.getProperty("password");
String driver = pro.getProperty("driver");
String url = pro.getProperty("url");

//连接驱动
Class.forName(driver);
//获取连接
Connection connection = DriverManager.getConnection(url,user,password);
System.out.println("连接成功五");
System.out.println(connection);

//这种连接方式使数据封装起来，有很好的保密性和可修改性
//实现了数据与代码的分离
//易于部署，当数据有所更改时，如果数据与代码分离，那么只修改配置文件即可，不用去改代码
```
```
url = jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf-8&allowPublicKeyRetrieval=true&useSSL=false&serverTimezone = UTC
user=root
password=zzy0927
driver=com.mysql.cj.jdbc.Driver
```
<a name="ZDWMp"></a>
## 三、使用PreparedStatement实现CRUD操作
<a name="JeQM0"></a>
#### 3.1  操作和访问数据库
:::info
PreparedStatement对象和Statement对象是接口和子接口的关系。

- 数据库连接被用于向数据库服务器发送领命和SQL语句，并接受服务器返回的结果，其实数据库连接就是一个Socket连接。
- 在java.sql包中有三个接口分别定义了对数据库的调用的不同方式 :
   - Statement：用于**返回静态的SQL语句**并返回它所生成结果的对象。
   - PreparedStatement：SQL语句被预编译并存储在此对象中，可以使用此对象多次高效地执行该语句。
   - CallableStatement：用于执行SQL存储过程。
:::
<a name="vF0R0"></a>
#### 	3.2  使用Statement存在弊端
:::info

- 使用Statement操作数据表存在弊端：
   - 问题一：存在拼接字符串操作，很繁琐
   - 问题二：存在SQL注入问题，账户和密码错误也能成功登录
   - SQL注入是利用系统没有对用户输入进行充分地检查，而在用户输入数据时注入非法的SQL语句命令段（如：SELECT user,password FROM user_table WHERE user = 'a' OR 1 = 'AND password = ' OR '1' = '1'），从而利用系统的SQL引擎完成恶意行为的做法，红字去掉恶意效果会更明显
- 对于java而言，要防范SQL注入，只要用PreparedStatement(从Statement扩展而来)取代Statement就可以了。
:::
<a name="XdM6t"></a>
#### 	3.3  PreparedStatement的使用
<a name="WVBPg"></a>
##### 3.3.1 增删改操作
```java
public static void InsertSQL(Connection connection) throws Exception
{    
	//value(?,?,?) ?代表一个占位符
    String sql = "INSERT INTO customers(name,email,birth) values(?,?,?)";
    
    //预编译SQL语句，返回一个 PreparedStatement 的实例
    PreparedStatement ps = connection.prepareStatement(sql);
    
    //填充占位符
    // set类型 第一个参数为填充的位置，第二个参数为填充的内容
    ps.setString(1,"坤");
    ps.setString(2,"ji@gmail.com");
    SimpleDateFormat sdf =  new SimpleDateFormat("yyyy-MM-DD");
    //对日期进行格式化 y 为 year四位数字, M 为 month两位数字, D为 day 两位数字
    java.util.Date date = sdf.parse("1998-08-02");
    //SimpleDateFormat.parse()用于将输入的特定字符串转换成 Date类的对象
    ps.setDate(3, new Date(date.getTime()));
    
    //执行 SQL操作
    ps.execute();
    System.out.println("插入成功");
    
    //关闭资源
    ps.close();
    connection.close();
}
```
```java
public static void InsertSQL(Connection connection, PreparedStatement ps) throws Exception
{
    // Alter 操作，修改表
    
    // connection 已经获取数据库连接
    
    // 预编译SQL语句
    String sql = "UPDATE customers SET name = ? WHERE id = ?";
    ps = connection.prepareStatement(sql);
    
    // 填充占位符
    ps.setString(1, "莫扎特");
    ps.setInt(2, 18);
    
    // 提交数据
    ps.execute();
    System.out.println("数据修改成功");
}
```
```java
public void DeleteSQL(Connection connection, PreparedStatement ps) throws Exception
{
	// 1. 获取连接
    // 2. 预编译SQL语句
    String sql = "DELETE FROM customers WHERE id = ?";
    ps = connection.prepareStatement(sql);
    
    // 3.填充占位符
    ps.setInt(1, 33);
    
    //4.提交数据
    ps.execute();
    System.out.println("删除成功");
}
```
<a name="BUxHT"></a>
##### 	    3.3.2 通用的增删改操作
```java
public static void UniverseOperation(Connection connection, PreparedStatement ps, String sql, Object ...args) throws Exception
{
    // 通用的增删改操作
    // Object ...args 为可变形参，具体有几个参数就看传了几个参数，类型为 所有类的父类 Object
	// 例如你参入的是 (conn, ps, sql, "AAA", 2, "CC");
    // 那么可变形参 args 的长度就为 3，args数组里的数据依次存放最后三个值
    
    // 1.连接数据库

    // 2.预编译
    ps = connection.prepareStatement(sql);

    // 3.填充占位符
    for(int i = 0; i < args.length; i++)
    {
        ps.setObject(i + 1, args[i]);
        // 注意：占位符都是从 1开始的，所以 i 要加 1
    }

    // 4.提交数据
    ps.execute();
    System.out.println("完成操作");
}
```
<a name="nnTG8"></a>
##### 3.3.3 查找操作
```java
public static void SelectSQL(Connection connection, PreparedStatement ps, ResultSet resultSet) throws Exception
{
    // 1.数据库连接
    // 2.预编译
    String sql = "SELECT id,name,email,birth FROM customers WHERE id = ?";
    ps = connection.prepareStatement(sql);

    // 3.填充字符
    ps.setInt(1, 1);

    // 4.提交数据,返回一个结果集
    // PreparedStatement 接口中有一个方法executeQuery()：execute:执行，Query:查询，它返回一个结果集
    resultSet = ps.executeQuery();
    // next()判断是否有下一条数据，如果有数据返回 true,指针指向下一个对象
    if(resultSet.next())
    {
        int id = resultSet.getInt(1);
        String name = resultSet.getString(2);
        String email = resultSet.getString(3);
        Date birth = resultSet.getDate(4);

        Customer customer = new Customer(id, name, email, birth);
        // 将所有数据封装到一个类中，这个类是自己定义的, 里面的数据都设置为 private，防止数据泄露
        System.out.println(customer.toString());
    }
    System.out.println("查找成功");
}
```
```java
public static Customer UniverseSelectSQL(Connection connection, PreparedStatement ps, ResultSet resultSet, String sql, Object ...args) throws Exception
{
    //获取数据库连接
    //预编译
    ps = connection.prepareStatement(sql);
    //填充占位符
    for(int i = 0; i < args.length; i++)
    {
        ps.setObject(i+1, args[i]);
    }

    resultSet = ps.executeQuery();
    //获取结果集的元数据：ResultSetMetaData
    ResultSetMetaData rsmd = resultSet.getMetaData();
    //获取元数据的列数，也就是获取传入的 sql 中要查询几列
    int columnCount = rsmd.getColumnCount();
    if(resultSet.next())
    {
        Customer customer = new Customer();
        // 处理结果集中的每一列
        for(int i = 0; i < columnCount; i++)
        {
            // 获取结果集中的一个字段的值
            Object columnValue = resultSet.getObject(i + 1);
            // 用元数据 rsmd 获取这个字段的名字
            String columnName = rsmd.getColumnName(i + 1);
            // 这里 rsmd 还有一个方法是获取列的别名
            // String columnName = rsmd.getColumnLabel();

            // 通过反射 找到 customer 类中与 columnName 相同的名字 变量，把 columnValue 的值 赋值给 这个变量
            // 注意：有可能你要查询的字段名 和 customer 类中的变量名不一致，但是他俩是一一对应的关系，
            // 这时我们要在 sql 语句中是变量换一个别名，这个别名与 customer 类中的变量名相同，
            // 这样就会查找到与 customer中某一个变量名相同的 columnName，并把 columnValue赋值给这个变量
            // 注意：如果设置了别名，那么这里要调用上面获取别名的方法 rsmd.getColumnLabel();
            // 如果没有别名，那么就要返会列原来的名字，所以推荐使用 getColumnLabel()方法
            Field field = Customer.class.getDeclaredField(columnName);
            field.setAccessible(true);
            field.set(customer, columnValue);

        }
        System.out.println(customer.toString());
        return customer;
    }
    return null;
}
```
```java
public static <T>T UniverseSelectSQL(Class<T> clazz, String sql, Object ...args) throws Exception
{
    // 参数利用 泛型获取要传入的类的类型
    // 返回一个 T 的泛型
    // 使用 PreparedStatement 实现针对不同表的查询操作

    // 1.获取连接
    Class.forName("com.mysql.cj.jdbc.Driver");
    Connection connection = ConnectionClassFIve.ConnecionClass5();

    //预编译
    PreparedStatement ps = connection.prepareStatement(sql);
    //填充占位符
    for(int i = 0; i < args.length; i++)
    {
        ps.setObject(i + 1, args[i]);
    }

    // 提交数据并返回结果集
    ResultSet rs = ps.executeQuery();
    ResultSetMetaData rsmd = rs.getMetaData();
    int columnCount = rsmd.getColumnCount();
    if(rs.next())
    {
        T t = clazz.getConstructor().newInstance();
        // 给任何一个类提供一个空参的 public 权限的构造器并且赋值给 t
        for(int i = 0; i < columnCount; i++)
        {
            String columnName = rsmd.getColumnLabel(i+1);
            Object columnValue = rs.getObject(i+1);
            // 反射赋值
            Field field = clazz.getDeclaredField(columnName);
            field.setAccessible(true);
            field.set(t, columnValue);
        }
        System.out.println(t);
        // 关闭所有资源
        close.closeResource(connection, ps, rs);
        return t;
    }
    close.closeResource(connection, ps, rs);
    return null;
}
```
```java
public static <T> List<T> SelectManyResult(Class<T> clazz, String sql, Object ...args) throws Exception
{
    // 查询多条记录并返回
    // 因为要查询多条结果，所以要返回一个数组
    // 1.获取连接
    Connection connection = ConnectionClassFIve.ConnecionClass5();

    // 2.预编译
    PreparedStatement ps = connection.prepareStatement(sql);
    for(int i = 0; i < args.length; i++)
    {
        ps.setObject(i+1, args[i]);
    }

    // 3.提交数据并返回结果
    ResultSet rs = ps.executeQuery();
    ResultSetMetaData rsmd = rs.getMetaData();
    int columnCount = rsmd.getColumnCount();
    // 创建一个 ArrayList<T> 泛型对象。
    ArrayList<T> list = new ArrayList<T>();
    while(rs.next())
    {
        T t = clazz.getConstructor().newInstance();
        for(int i = 0; i < columnCount; i++)
        {
            String columnName = rsmd.getColumnLabel(i+1);
            Object columnValue = rs.getObject(i+1);
            Field field =  clazz.getDeclaredField(columnName);
            field.setAccessible(true);
            field.set(t, columnValue);
        }
        System.out.println(t);
        // 将 t 对象添加到数组里
        list.add(t);
    }
    close.closeResource(connection, ps, rs);
    return list;
}
```
<a name="CwGKM"></a>
#####             3.3.4 处理Blob类型文件
```java
// 向数据表中插入 blob 类型的字段
connection = ConnectionClassFIve.ConnecionClass5();
String sql = "INSERT INTO customers(name, email, birth, photo) VALUES(?,?,?,?)";
ps = connection.prepareStatement(sql);
ps.setString(1, "张三");
ps.setString(2, "zhang@qq.com");
ps.setObject(3, "1999-09-21");
// 用 io 输入流把文件输入进来，用 FileInputStream 类型对象接受
FileInputStream is = new FileInputStream("C:\\Users\\lenovo\\Pictures\\1.webp");
// setBlob 方法
ps.setBlob(4, is);
ps.execute();
close.closeResource(connection, ps);
```
```java
connection = ConnectionClassFIve.ConnecionClass5();
String sql = "SELECT id,name,email,birth,photo FROM customers WHERE id = ?";
ps = connection.prepareStatement(sql);
ps.setInt(1, 16);
ResultSet rs = ps.executeQuery();
Blob photo = null;
if(rs.next())
{
    int id = rs.getInt(1);
    String name = rs.getString(2);
    String email = rs.getString(3);
    Date birth = rs.getDate(4);
    Customer customer = new Customer(id, name, email, birth);
    System.out.println(customer);
    photo = rs.getBlob(5);
    // 用流数据读取 Blob 文件
    InputStream is = photo.getBinaryStream();
    // 将文件保存到本地
    FileOutputStream fos = new FileOutputStream("朱茵.jpg");
    byte[] buffer = new byte[1024];
    int len;
    while((len = is.read(buffer)) != -1)
    {
        fos.write(buffer, 0, len);
    }
}
close.closeResource(connection, ps, rs);
```
<a name="XI3IV"></a>
#####    3.3.5 批量插入多条数据
```java
/*
 * 使用 PreparedStatement 实现批量数据操作
 * 主要展示使用 PreparedStatement 如何实现高效的批量插入操作
 * 题目： 向 goods 表中插入 20000条数据
 * 方式1 ： 使用 Statement 做批量插入操作
 * conncetion = ConncetionClassFIve.ConnectionClass5();		连接
 * Statement st = connection.createStatement();				生成 Statement 对象
 * for(int i = 0; i < 20000; i++)
 * {
 *     String sql = "INSERT INTO goods VALUE('name_" + i + "')";	生成 sql 语句
 *     st.execute(sql);										提交数据
 * }
*/
// 方式2 ：
String sql = "INSERT INTO goods(name) VALUE(?)";
ps = connection.prepareStatement(sql);
for(int i = 0; i < 20000; i++)
{
    ps.setString(1, "name_"+i);
    ps.execute();
}
close.closeResource(connection, ps);
/*
 *	和 Statement 相比， PreparedStatement做批量插入的好处：
 *	DBServer会对预编译语句提供性能优化。因为预编译可能会被重复调用，
 *	所以语句在被DBServer的编译器编译的代码执行下来，那么下次再调用时只要是相同的预编译语句
 *  就不需要再编译，只要将参数传入就行。
 *	而在 Statement 语句中，即使是相同操作，因为数据内容不一样，所以整个语句本身不能匹配，没有
 *  缓存的意义。所以， 执行PreparedStatement 语句要比 Statement 语句要快很多。
 */
```
```java
// 对 ManyDataOperator 函数的优化： 不再读取一个 i 填充一个占位符，而是等一批数据一起填充
String sql = "INSERT INTO goods(name) VALUE(?)";
ps = connection.prepareStatement(sql);
for(int i = 0; i < 20000; i++)
{
    ps.setString(1, "name_"+i);
    // 攒数据, batch 批处理，默认情况下，mysql是不支持批处理的，所以要在 配置文件 url 后面加一个 rewriteBatchedStatements=true;
    ps.addBatch();
    // 每隔 500 次插入一遍数据，一次插入 500条，并把这500条数据提交到数据库
    if(i % 500 == 0)
        ps.executeBatch();
    // 提交依次，清空一次 Batch
    ps.clearBatch();
}
close.closeResource(connection, ps);
// 此方法的好处，不用一次一次的提交数据，大大减少了时间的利用率
```
```java
public static void OptimizeConnection() throws Exception {
Connection connection = ConnectionClassFIve.ConnecionClass5();
// 不允许自动提交数据，等最后数据传完一起提交
connection.setAutoCommit(false);
String sql = "INSERT INTO goods(name) VALUES(?)";
long start = System.currentTimeMillis();
PreparedStatement ps = connection.prepareStatement(sql);
for(int i = 0; i < 20000; i++)
{
    ps.setString(1, "name_"+i);
    ps.addBatch();
    if(i % 500 == 0)
    {
        // 这里光插入 500 条数据，不再自动提交数据
        ps.executeBatch();
        ps.clearBatch();
    }
}
// 把数据一起提交上去
connection.commit();
long end = System.currentTimeMillis();
System.out.println(end - start);
close.closeResource(connection, ps);
}
```
<a name="KhGx0"></a>
## 四、*数据库事务
<a name="mxQFo"></a>
##### 4.1 事务库介绍以及处理原则
:::info
 数据库事务:<br /> 	事务：一组逻辑操作单元，是数据从一组状态变换到另一种状态<br />  	一组逻辑操作单元：一个或多个 DML 操作，多个 DML 操作之间有关联，称这多个 DML 操作为 一组逻辑单元<br /> 	事务处理的原则： 需要保证事务都作为一个工作单元来执行，即使除了故障，都不能改变这种执行方式，<br /> 要么所有数据都被提交 commit，数据被永久保存下来，注意：数据一旦提交，就不可回滚，要么数据库放弃所有的操作，同时数据库 rollback 到最初的状态。<br />DDL：数据库定义语言（ ALTER\CREATE\DROP\TRUNCATE ）<br />DML：数据库操作语言（ INSERT\UPDATE\DELETE ）<br />DDL操作一旦执行，都会自动提交<br />DML默认情况下，一旦执行，会自动提交 -> set autocommit = false 取消自动提交，这个操作对 DDL 失效<br />默认在关闭连接时会自动提交之前执行操作更新的数据
:::
<a name="kQNC6"></a>
##### 4.2 代码处理
```java
public static void OptimizeUniverseDML(Connection connection, String sql, Object... args) throws Exception
{
    // 对通用的增删改操作（UniverseOperation）进行优化,考虑了事务的属性
    PreparedStatement ps = connection.prepareStatement(sql);

    // 3.填充占位符
    for(int i = 0; i < args.length; i++)
    {
        ps.setObject(i + 1, args[i]);
        // 注意：占位符都是从 1开始的，所以 i 要加 1
    }

    // 4.提交数据
    ps.execute();
    System.out.println("完成操作");
    //  close.closeResource(connection, ps);
    //  连接不在函数内部生成，传入一个连接 connection, 同时也不在函数内部关闭连接，
    //  在外部所有数据提交完后关闭连接，否则在外部 rollback 数据
}
}
```
```java
public static void transaction() throws Exception
{
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
        // 恢复默认提交数据为 true,即恢复连接为默认值
        connection.setAutoCommit(true);
        // 不管数据是否回滚，都要关闭连接
        close.closeResource(connection, null);
    }
}
```
<a name="gmIkG"></a>
##### 4.3 事务的ACID操作
:::info
事务的 ACID 属性<br />1.原子性：事务是一个不可分割的工作单位，要么都发生，要么都不发生<br />2.一致性：事务必须从一个一致性状态变换为另一个一致性状态<br />3.隔离性：一个事务给另一个事务不能产生干扰，一个事务内操作的数据另一个事务是不影响的，并发执行的各个事务之间互不影响<br />4.持久性：一个事务一旦被提交，那么它对数据库的改变是永久性的，接下来的其他操作和数据库故障不会对其产生任何影响
:::
<a name="Dst72"></a>
##### 4.4 数据库的并发问题
:::info
数据库的并发问题：<br />对于多个运行的事务，当这些事务访问数据库相同的数据时，如果没有采用必要的隔离机制，就会导致各种并发问题：<br />	1.脏读：对于两个事务 T1,T2，如果 T1读取了已经被 T2更新但是还没有提交的字段，之后，若 T2 回滚，T1 读取的数据是临时且无效的，这个问题是必须要被解决的。<br />	2.不可重复读：对于两个事务 T1,T2,如果 T1 读取了一个字段，然后 T2 更新了该字段，之后 T1 再次读取该字段时发现该字段的值已经被改变。脏读这个问题是可以被接受的<br />	3.幻读：对于两个事务 T1,T2, T1从一个表中读取了一个字段，然后 T2 插入了一些新的行，之后，如果 T1 再次查询这个表时会发现表多处几行数据，幻读这个问题是可以被接受的。
:::
<a name="S8dPw"></a>
#####       4.5 数据库提供的四种隔离级别
:::info
四种隔离级别：<br />	1. READ UNCOMMITTED（读未提交数据）,脏读、不可重复读、幻读都未解决<br />	2. READ COMMITTED     （读已提交数据）,解决了脏读<br />	3. REPEATABLE READ      （可重复读）,解决了脏读、不可重复读，当 T2 更新完数据后，如果 T1 还未关闭连接，那么 T1 读到的还是原来的数据，MySQL默认为此种方式<br />	4. SERIALIZABLE              （串行化）,解决了脏读、不可重复读、幻读，当 T2 插入完数据后，如果 T1 还未关闭连接，那么 T1 查到的还是原来的数据<br /> 四种隔离级别从上往下，并发性越差，一致性越好
:::
<a name="KjIbW"></a>
##### 	4.6 查看、更改隔离级别
:::info
在 MySQL 8.0 版本中：<br />查看数据库事务的隔离级别： select @@transaction_isolation;<br />更改数据库事务的隔离级别： set global transaciton isolation level 隔离级别；
:::
<a name="CjnL0"></a>
## 五、DAO及实现类
<a name="DKEcx"></a>
##### 5.1 DAO的定义
:::info
DAO是一个类，这个类封装了数据表通用的一些操作，这个类只是提供了一些方法，不会去实例化，所以要把它声明为 abstract 抽象类，这个抽象类里有增删改查表的通用操作。
:::
```java
public abstract class BaseDAO   // 因为不能实例化，所以声明为 abstract
{
    public static void OptimizeUniverseDML(Connection connection, String sql, Object... args) throws Exception  {
        // 对通用的增删改操作（UniverseOperation）进行优化,考虑了事务的属性
        PreparedStatement ps = connection.prepareStatement(sql);

        // 3.填充占位符
        for(int i = 0; i < args.length; i++)
        {
            ps.setObject(i + 1, args[i]);
            // 注意：占位符都是从 1开始的，所以 i 要加 1
        }

        // 4.提交数据
        ps.execute();
        System.out.println("完成操作");
        close.closeResource(null, ps);
        //  连接不在函数内部生成，传入一个连接 connection, 同时也不在函数内部关闭连接，
        //  在外部所有数据提交完后关闭连接，否则在外部 rollback 数据
    }
    public static <T>T UniverseSelectSQL(Connection connection, Class<T> clazz, String sql, Object ...args) throws Exception {
        // 使用 PreparedStatement 实现针对不同表的查询操作

        //预编译
        PreparedStatement ps = connection.prepareStatement(sql);
        //填充占位符
        for(int i = 0; i < args.length; i++)
        {
            ps.setObject(i + 1, args[i]);
        }

        // 提交数据并返回结果集
        ResultSet rs = ps.executeQuery();
        ResultSetMetaData rsmd = rs.getMetaData();
        int columnCount = rsmd.getColumnCount();
        if(rs.next())
        {
            T t = clazz.getConstructor().newInstance();
            // 给任何一个类提供一个空参的 public 权限的构造器
            for(int i = 0; i < columnCount; i++)
            {
                String columnName = rsmd.getColumnLabel(i+1);
                Object columnValue = rs.getObject(i+1);
                Field field = clazz.getDeclaredField(columnName);
                field.setAccessible(true);
                field.set(t, columnValue);
            }
            System.out.println(t);
            close.closeResource(null, ps, rs);
            return t;
        }
        close.closeResource(null, ps, rs);
        return null;
    }
    public static <T> List<T> SelectManyResult(Connection connection, Class<T> clazz, String sql, Object ...args) throws Exception {
        // 2.预编译
        PreparedStatement ps = connection.prepareStatement(sql);
        for(int i = 0; i < args.length; i++)
        {
            ps.setObject(i+1, args[i]);
        }

        // 3.提交数据并返回结果
        ResultSet rs = ps.executeQuery();
        ResultSetMetaData rsmd = rs.getMetaData();
        int columnCount = rsmd.getColumnCount();
        ArrayList<T> list = new ArrayList<T>();
        while(rs.next())
        {
            T t = clazz.getConstructor().newInstance();
            for(int i = 0; i < columnCount; i++)
            {
                String columnName = rsmd.getColumnLabel(i+1);
                Object columnValue = rs.getObject(i+1);
                Field field =  clazz.getDeclaredField(columnName);
                field.setAccessible(true);
                field.set(t, columnValue);
            }
            System.out.println(t);
            list.add(t);
        }
        close.closeResource(null, ps, rs);
        return list;
    }
    public static <T>T GetValue(Connection connection, String sql,Object ...args) throws Exception {
// 针对 SELECT COUNT(*) FROM TABLE; 这类单行函数的操作进行返回一条数据，因为不确定是什么类型，所以用到了泛型。
PreparedStatement ps = null;
ps = connection.prepareStatement(sql);
ResultSet rs = null;
for(int i = 0; i < args.length; i++)
{
ps.setObject(i + 1, args[i]);
}
rs = ps.executeQuery();
if(rs.next())
{
close.closeResource(null, ps, rs);
return  (T) rs.getObject(1);
}
close.closeResource(null, ps, rs);
return null;
}
}
```
<a name="UX2Kq"></a>
##### 	5.2 针对Customer表的具体操作
:::info
 定义一个接口 CustomerDAO,此接口用于规范针对于 customers 表的常用操作,这个接口只针对于Customer 表，对 Customer 表进行一些具体的操作，而 BaseDAO 类是所有表都可以进行的操作，在定义一个类去继承BaseDAO和implements 接口，使操作更加的规范, 也就是说接口用于给出表的具体操作，而 BaseDAO 表给出的是一些通用的操作，还有一个类去继承类和实现接口。<br />可以说，给每个表都定义一个具体的接口，用这个接口去定义一些具体的操作，在定义一个类去 继承BaseDAO 和 implements 接口，这样使操作更加的规范。
:::
```java
public interface CustomerDAO
{
    void insert(Connection connection, Customer cust);
    void deleteById(Connection connection, int id);
    // 针对内存中的 cust对象，去修改数据表中指定的记录
    void updateById(Connection connection, Customer cust);
    Customer getCustomerById(Connection connection, int id);
    // 查询表中所有记录构成的集合
    List<Customer> getAll(Connection connection);
    // 返回数据表中的条目数
    Long getCount(Connection connection);
    // 返回数据表中最大的生日
    Date getMaxBirth(Connection connection);
}
```
```java
public class CustomersDAOImpl extends BaseDAO implements CustomerDAO
{
    // 可以看出这个类继承的具体方法都用到了BaseDAO类通用方法。

    @Override
    public void insert(Connection connection, Customer cust) throws Exception {
        String sql = "INSERT INTO customers(name,email,birth) VALUES(?,?,?)";
        OptimizeUniverseDML(connection, sql, cust.getName(), cust.getEmail(), cust.getDate());
    }

    @Override
    public void deleteById(Connection connection, int id) throws Exception {
        String sql = "DELETE FROM customers WHERE id = ?";
        OptimizeUniverseDML(connection, sql, id);
    }

    @Override
    public void updateById(Connection connection, Customer cust) throws Exception {
        String sql = "UPDATE customers SET name = ?,email = ?,birth = ? WHERE id = ?";
        OptimizeUniverseDML(connection, sql, cust.getName(), cust.getEmail(), cust.getDate(), cust.getId());
    }

    @Override
    public Customer getCustomerById(Connection connection, int id) throws Exception {
        String sql = "SELECT id,name,birth FROM customers WHERE id = ?";
        Customer customer = UniverseSelectSQL(connection, Customer.class, sql, id);
        return customer;
    }

    @Override
    public List<Customer> getAll(Connection connection) throws Exception {
        String sql = "SELECT id,name,birth,email FROM customers WHERE";
        List<Customer> customers = SelectManyResult(connection, Customer.class, sql);
        return customers;
    }

    @Override
    public Long getCount(Connection connection) throws Exception {
        String sql = "SELECT count(*) FROM customers";
        return getValue(connection,sql);
    }

    @Override
    public Date getMaxBirth(Connection connection) throws Exception {
        String sql = "SELECT MAX(birth) FROM customers";
        return getValue(connection, sql);
    }
}
```
```java
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
```
<a name="I7fU9"></a>
##### 	5.3 针对上述接口、类的优化
:::info
因为确定要针对Customers表进行操作，所以在调用父类BaseDAO里的方法时，例如：<br />UniverseSelectSQL(connection, Customer.class, sql, id)，还要用反射传入 Customers.clazz, 所以优化要去掉这种反射传入的操作。
:::
```java
public abstract class BaseDAO<T>   //利用泛型规定传入的类型
{
    private Class<T> clazz = null;	//此时 clazz 是 Customer 类型。
    // 非静态代码块实例化 clazz
    // 获取当前BaseDAO的子类继承的父类中的泛型
    {
        Type genericSuperclass = this.getClass().getGenericSuperclass();        // 获取当前对象的带泛型的父类，也就是获取 Base<Customer>,当前对象是 Customer
        ParameterizedType paramType = (ParameterizedType) genericSuperclass;    // 强转为可以带参数的类型
        Type[] actualTypeArguments = paramType.getActualTypeArguments();        // 获取父类的泛型参数
        clazz = (Class<T>) actualTypeArguments[0];                              // 因为只有一个参数 Customer,所以用第一个索引，再强转为要传入的类型，也就是 Customer
    }
    
    public void OptimizeUniverseDML(Connection connection, String sql, Object... args) throws Exception  {
        PreparedStatement ps = connection.prepareStatement(sql);
        for(int i = 0; i < args.length; i++)
        {
            ps.setObject(i + 1, args[i]);
        }
        ps.execute();
        System.out.println("完成操作");
        close.closeResource(null, ps);
    }
    // 此方法不再反射获取类的类型，因为在开始就已经获取了类的类型。
    public T UniverseSelectSQL(Connection connection, String sql, Object ...args) throws Exception {
        PreparedStatement ps = connection.prepareStatement(sql);
        for(int i = 0; i < args.length; i++)
        {
            ps.setObject(i + 1, args[i]);
        }
        ResultSet rs = ps.executeQuery();
        ResultSetMetaData rsmd = rs.getMetaData();
        int columnCount = rsmd.getColumnCount();
        if(rs.next())
        {
            T t = clazz.getConstructor().newInstance();
            for(int i = 0; i < columnCount; i++)
            {
                String columnName = rsmd.getColumnLabel(i+1);
                Object columnValue = rs.getObject(i+1);
                Field field = clazz.getDeclaredField(columnName);
                field.setAccessible(true);
                field.set(t, columnValue);
            }
            System.out.println(t);
            close.closeResource(null, ps, rs);
            return t;
        }
        close.closeResource(null, ps, rs);
        return null;
    }
    public List<T> SelectManyResult(Connection connection, String sql, Object ...args) throws Exception {
        PreparedStatement ps = connection.prepareStatement(sql);
        for(int i = 0; i < args.length; i++)
        {
            ps.setObject(i+1, args[i]);
        }
        ResultSet rs = ps.executeQuery();
        ResultSetMetaData rsmd = rs.getMetaData();
        int columnCount = rsmd.getColumnCount();
        ArrayList<T> list = new ArrayList<T>();
        while(rs.next())
        {
            T t = clazz.getConstructor().newInstance();
            for(int i = 0; i < columnCount; i++)
            {
                String columnName = rsmd.getColumnLabel(i+1);
                Object columnValue = rs.getObject(i+1);
                Field field =  clazz.getDeclaredField(columnName);
                field.setAccessible(true);
                field.set(t, columnValue);
            }
            System.out.println(t);
            list.add(t);
        }
        close.closeResource(null, ps, rs);
        return list;
    }
    public <T>T getValue(Connection connection, String sql) throws Exception {
        PreparedStatement ps = null;
        ps = connection.prepareStatement(sql);
        ResultSet rs = null;
        rs = ps.executeQuery();
        if(rs.next())
        {
            return  (T) rs.getObject(1);
        }
        return null;
    }
}
```
```java
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
        // 不再用反射传入 Customer 类
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
```
<a name="ugEWA"></a>
##  六、数据库连接池
<a name="Iuhou"></a>
##### 6.1 数据库连接池的引入
:::info
因为每次用 DriverManager 连接数据库都会耗费 0.5~1s的时间，当有 500 多人同时访问服务器时，服务器响应会非常的慢，同时在程序中如果出现异常从而没有正常关闭连接，那么还会导致 java内存泄露的问题。所以，为了解决这些问题，引入了数据库连接池的概念。
:::
<a name="I4MI9"></a>
##### 6.2 数据库连接池的基本思想
:::info
就是为数据库建立一个缓冲池，预先在缓冲池中放入一定数量的连接，此时所有连接都为free状态，当需要建立数据库连接时，只需从缓冲池中取出一个，用完后再放回去。<br />当缓冲池中的连接都被取完，此时所有连接都为busy状态，此时又有一个程序想要连接，那么这个程序就等待其他任意一个程序释放掉连接(不是关闭连接，是把连接放回缓冲池，连接状态由busy改为free状态)，那么这个程序再去获取连接。
:::
<a name="ThjOu"></a>
##### 	6.3 多种开源的数据库连接池
:::info
JDBC的数据库连接池使用java.sql.DataSource来表示，DataSource是一个接口，该接口通常由服务器(Weblogic, WebSphere, Tomcat)提供实现，也有一些开源组织提供实现：

   - DBCP是 Apache提供的数据库连接池，Tomcat 服务器自带 DBCP数据库连接池。速度相较于C3P0快，但因自身存在BUG，Hibernate3已不再支持。
   - C3P0是一个开源组织提供的一个数据库连接池，速度相对较慢，稳定性还可以。
   - Proxool 是sourceforge下的一个开源项目数据库连接池，由监控连接池状态的功能，稳定性较C3P0差一点。
   - BoneCP是一个开源组织提供的数据库连接池，速度快。
   - Druid(德鲁伊)是阿里提供的数据库连接池，据说是集DBCP、C3P0、Peoxool优点于一身的数据库连接池，但是速度不确定是否有BoneCP快，现在主流用 Druid数据库连接池。
- DataSource 通常被称为数据源，它包含连接池和连接池管理两个部分，习惯上也经常把DataSource称为连接池
- DataSource用来取代DriverManager来获取Connection,获取速度快，同时可以大幅度提高数据库访问速度。
:::
<a name="itPny"></a>
##### 	6.4 C3P0数据池连接
```java
// 方式一：暴漏 url,user,password,驱动
@Test
public void testGetConnection1() throws Exception
{
    ComboPooledDataSource cpds = new ComboPooledDataSource();   // 生成一个数据库连接池对象
    cpds.setDriverClass("com.mysql.cj.jdbc.Driver");
    cpds.setJdbcUrl("jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf-8&allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC&rewriteBitchedStatements=true");
    cpds.setUser("root");
    cpds.setPassword("zzy0927");
    cpds.setInitialPoolSize(10);    // 设置初始时数据库连接池中数量为 10 个
    Connection connection = cpds.getConnection();
    System.out.println(connection);
    // 连接池一般情况下不关闭，只收回对外放出去的连接
}
```
```java
// 方式 2：封装
@Test
public void testGetConnection2() throws Exception {
    // 将 驱动地址、url、用户名、密码封装在 xml 文件内,且这个文件名字、内容是按照 c3p0定义写的
    ComboPooledDataSource cpds = new ComboPooledDataSource("HelloC3p0");  // 封装的 xml文件中 自定义配置名称
    Connection connection = cpds.getConnection();
    System.out.println(connection);
}
```
```xml
<?xml version="1.0" encoding="GBK" ?>
<c3p0-config>
  <!-- 自定义配置-->
  <named-config name="HelloC3p0">
    <!-- 提供数据库的 4 個基本信息-->
    <property name="DriverClass">com.mysql.cj.jdbc.Driver</property>
    <property name="JdbcUrl">jdbc:mysql://localhost:3306/test?useUnicode=true&amp;characterEncoding=utf-8&amp;allowPublicKeyRetrieval=true&amp;useSSL=false&amp;serverTimezone=UTC&amp;rewriteBitchedStatements=true</property>
    <property name="User">root</property>
    <property name="Password">zzy0927</property>
    <!-- 进行数据库连接池管理的基本信息-->
    <property name="acquireIncrement">50</property>     <!-- 当数据库连接池中连接数不够时，c3p0一次性向数据库服务器申请的连接数-->
    <property name="initialPoolSize">10</property>      <!-- c3p0数据库连接池中初始化时的连接数-->
    <property name="minPoolSize">10</property>          <!-- c3p0数据库连接池中维护的最少连接数-->
    <property name="maxPoolSize">1000</property>        <!-- c3p0数据库连接池中维护的最多连接数-->
    <property name="maxStatements">50</property>         <!-- c3p0数据库连接池中最多维护的 Statement 个数-->
    <property name="maxStatementsPerConnection">2</property>    <!-- 每个连接中最多可以使用的 Statement 个数-->

  </named-config>
</c3p0-config>
```
<a name="uwZWk"></a>
###### 6.4.1 将新旧两种加载方式加载到类中
```java
public class Connection
{
    // 新加载方式
    // cpds 是一个池子，池子里面有很多连接，所以池子只需要一个。
 	// 放在方法体外面，多个对象同时调用连接时，不用每次都生成一个对象，因为相当于生成了多个池子。
    private static ComboPooledDataSource cpds = new ComboPooledDataSource("HelloC3p0");  // 封装的 xml文件中 自定义配置名称
    public static java.sql.Connection getConnection() throws Exception
    {
        java.sql.Connection connection = cpds.getConnection();
        return connection;
    }
    // 旧加载方式
    // 旧加载方式是调用时生成一个连接，用完释放连接。
    public static java.sql.Connection ConnecionClass5() throws Exception
    {
        // 第五种连接方式
        InputStream is = new FileInputStream("E:\\java\\java_data\\java_jdbc\\jdbc\\src\\com\\connection\\jdbc.properties");
        Properties pro =new Properties();
        pro.load(is);

        String user = pro.getProperty("user");
        String password = pro.getProperty("password");
        String driver = pro.getProperty("driver");
        String url = pro.getProperty("url");

        Class.forName(driver);
        java.sql.Connection connection = DriverManager.getConnection(url,user,password);
        System.out.println("连接成功五");
        System.out.println(connection);
        return connection;
    }
}
```
<a name="uwYq7"></a>
##### 6.5 DBCP数据池连接
```java
@Test
// 测试 DBCP 数据库连接池技术
public void testDbcpGetConnection() throws Exception
{
    // 创建了 dbcp 的数据库连接池
    BasicDataSource bds = new BasicDataSource();
    // 设置基本信息
    bds.setDriverClassName("com.mysql.cj.jdbc.Driver");
    bds.setUrl("jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf-8&allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC&rewriteBitchedStatements=true");
    bds.setUsername("root");
    bds.setPassword("zzy0927");
    // 还可以设置数据库连接池管理的相关属性
    // 参考 dbcp.txt
    bds.setInitialSize(10);
    bds.setMaxActive(50);
    Connection connection = bds.getConnection();
    System.out.println(connection);
}
```
```
dbcp连接池常用基本配置属性

1.initialSize ：连接池启动时创建的初始化连接数量（默认值为0）

2.maxActive ：连接池中可同时连接的最大的连接数（默认值为8，调整为20，高峰单机器在20并发左右，自己根据应用场景定）

3.maxIdle：连接池中最大的空闲的连接数，超过的空闲连接将被释放，如果设置为负数表示不限制（默认为8个，maxIdle不能设置太小，因为假如在高负载的情况下，连接的打开时间比关闭的时间快，会引起连接池中idle的个数 上升超过maxIdle，而造成频繁的连接销毁和创建，类似于jvm参数中的Xmx设置)

4.minIdle：连接池中最小的空闲的连接数，低于这个数量会被创建新的连接（默认为0，调整为5，该参数越接近maxIdle，性能越好，因为连接的创建和销毁，都是需要消耗资源的；但是不能太大，因为在机器很空闲的时候，也会创建低于minidle个数的连接，类似于jvm参数中的Xmn设置）

5.maxWait  ：最大等待时间，当没有可用连接时，连接池等待连接释放的最大时间，超过该时间限制会抛出异常，如果设置-1表示无限等待（默认为无限，调整为60000ms，避免因线程池不够用，而导致请求被无限制挂起）

6.poolPreparedStatements：开启池的prepared（默认是false，未调整，经过测试，开启后的性能没有关闭的好。）

7.maxOpenPreparedStatements：开启池的prepared 后的同时最大连接数（默认无限制，同上，未配置）

8.minEvictableIdleTimeMillis  ：连接池中连接，在时间段内一直空闲， 被逐出连接池的时间

9.removeAbandonedTimeout  ：超过时间限制，回收没有用(废弃)的连接（默认为 300秒，调整为180）

10.removeAbandoned  ：超过removeAbandonedTimeout时间后，是否进 行没用连接（废弃）的回收（默认为false，调整为true)
```
```java
private static DataSource source;
    static  // 静态代码块，随着类的加载而加载，只执行一次,因为和 c3p0连接池一样，池子只生成一次
    {
        try{
            Properties pros = new Properties();
            InputStream is = new FileInputStream("jdbc/src/com/connectionPool/dbcp.properties");
            pros.load(is);
            source = BasicDataSourceFactory.createDataSource(pros);
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    @Test
    public Connection getDbcpGetConnection2() throws Exception
    {
        Connection connection = source.getConnection();
        System.out.println(connection);
        return connection;
    }
```
```
driverClassName=com.mysql.cj.jdbc.Driver
url=jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf-8&allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC&rewriteBitchedStatements=true
username=root
password=zzy0927
```
<a name="SlMZy"></a>
#####       6.6 Druid (德鲁伊）数据池连接
```java
private static DataSource source;
    static{
        try {
            Properties pros = new Properties();
            InputStream is = new FileInputStream("jdbc/src/com/connectionPool/druid.properties");
            pros.load(is);
            source = DruidDataSourceFactory.createDataSource(pros);
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    @Test
    public void getDruidConnection() throws Exception
    {
        Connection connection = source.getConnection();
        System.out.println(connection);
    }
```
```
url=jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf-8&allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC&rewriteBitchedStatements=true
username=root
password=zzy0927
driverClassName=com.mysql.cj.jdbc.Driver
```
<a name="X8bfc"></a>
## 七、Apache-DBUtils实现CRUD操作
<a name="QqC7Z"></a>
##### 7.1 Apache-DBUtils简介
:::info
commons-dbutils 是Apache组织提供的一个开源的JDBC工具类库，它是对JDBC的简单封装，学习成本低，并且使用dbutils能极大简化JDBC编码的工作量，同样也不会影响程序的性能。
:::
<a name="OfLmo"></a>
##### 7.2 CURD操作 
```java
@Test
public void testInsert() throws Exception
{
    QueryRunner runner = new QueryRunner();
    Connection connection = DruidTest.getDruidConnection();
    String sql = "INSERT INTO customers(name,email,birth) values(?,?,?)";
    // CURD 方法重载的方法有好几个，如果传入的参数有 Connection,那么它就不是一个单独的事务，不会在方法内部关闭连接导致数据不能回滚。
    // 如果没有传入 Connection,那么它就是一个单独的事务，在方法内部创建连接，程序运行完成后关闭连接。
    runner.update(connection,sql,"kunGe","kun@126.com","1997-08-02");
	close.closeResource(connection,null);
}
```
```java
@Test
public void testSelect() throws Exception {
    QueryRunner runner = new QueryRunner();
    Connection connection = DruidTest.getDruidConnection();
    String sql = "SELECT id,name,email,birth FROM customers WHERE id = ?";
    BeanHandler<Customer> handler = new BeanHandler<>(Customer.class);  // 把 Customer 类封装在 handler 中
    Customer result = runner.query(connection, sql, handler, 37);
    System.out.println(result);
	close.closeResource(connection,null);
}
```
```java
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
```
```java
@Test
public void SpecificResult() throws Exception{
    QueryRunner runner = new QueryRunner();
    Connection connection = DruidTest.getDruidConnection();
    String sql = "SELECT COUNT(*) FROM customers WHERE id < ?";
	// ScalarHandler 用于查询特殊值
    ScalarHandler handler = new ScalarHandler();
    Object query = runner.query(connection, sql, handler, 37);
    System.out.println(query);
    close.closeResource(connection,null);
}
```
<a name="OIHa5"></a>
#####       7.3 自定义查询语句
```java
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
```
<a name="EfAuf"></a>
#####       7.4 资源链接关闭
```java
DbUtils.closeQuietly(connection);
// DbUtils.closeQuietly(ps);
// DbUtils.closeQuietly(rs);
```
