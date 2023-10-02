<a name="AfygO"></a>
## Spring
<a name="iD4rs"></a>
### 概念
:::info
Spring提供了若干个项目，每个项目用于完成特定的功能<br />Spring Framework: Spring框架，Spring的其他技术都是依赖这个框架来完成的，这是一个底层的框架<br />Spring Boot：用于提高开发速度<br />Spring Cloud：分布式开发
:::
<a name="S6edN"></a>
### spring Framework系统架构
:::info

- Core Container: 核心容器，有Beans, Core, Context, SpEL
- Aspect: AOP思想实现
- AOP: 面向切面编程
- Data Access/Integration: 数据访问/集成，包括JDBC, ORM, OXM, JMS, Transaction
- Web: Web开发，包括WebSocket, Servlet, Web, Portlet
- Test: 单元测试与集成测试
:::
<a name="EfV3c"></a>
#### IoC
:::info

- IoC（Inversion of Control）控制反转：
   - 使用对象时，由主动new产生对象转换由外部提供对象，此过程中创建控制权由程序转移到外部，此思想为控制反转。	
   - Spring对IoC思想进行了实现：
      - Spring提供了一个容器，称为IoC容器，用来充当IoC思想中的“ 外部 ”
      - IoC容器负责对象的创建，初始化等一系列工作，被创建或被管理的对象在IoC容器中被称为Bean
- DI（Dependency Injection）依赖注入：
   - 在容器中建立bean与bean之间的依赖关系的整个过程，称为依赖注入
- 核心概念：充分解耦
   - 使用IoC容器管理bean
   - 在IoC容器中将有依赖关系的bean进行关系绑定
:::
<a name="dX1wK"></a>
#### IoC初步使用 - xml配置
```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">
    <!--配置IoC容器中的bean-->
    <bean id="bookDao" name="dao bookEbi" class="ssm.dao.impl.BookDaoImpl"/> 
    <!-- name属性主要用来定义id的别名，作用域和id相同，别名之间可以用, ; 空格 隔开 -->
  	<bean id="bookService" class="ssm.service.impl.BookServiceImpl"/>
</beans>
```
```java
public class BookDaoImpl implements BookDao {
    public void save() {
        System.out.println("book dao save ... ");
    }
}

public class BookServiceImpl implements BookService {
    private BookDao bookDao = new BookDaoImpl();		// 还是有部分耦合
    public void save() {
        System.out.println("book service save ...");
        bookDao.save();
    }
    
}

@SpringBootApplication
public class SsmApplication {
    public static void main(String[] args) {
        // 获取IoC容器
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        // 获取bean
        BookDao bookDao = (BookDao) context.getBean("bookDao");
        bookDao.save();

        BookService bookService = (BookService) context.getBean("bookService");
        bookService.save();
    }
}
```
<a name="MLLY4"></a>
#### DI初步使用 - xml配置
```java
public class BookDaoImpl implements BookDao {
    public void save() {
        System.out.println("book dao save ... ");
    }
}

public class BookServiceImpl implements BookService {
    private BookDao bookDao;			// 解耦
    public void save() {
        System.out.println("book service save ...");
        bookDao.save();
    }

    public void setBookDao(BookDao bookDao) {	// setter方法注入对象
        this.bookDao = bookDao;			// xml配置
    }

    public BookServiceImpl(BookDao bookDao1) {	// 构造器方法注入对象
        this.bookDao = bookDao1;
    }
}

@SpringBootApplication
public class SsmApplication {
    public static void main(String[] args) {
        // 获取IoC容器
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        // 获取bean
        BookDao bookDao = (BookDao) context.getBean("bookDao");
        bookDao.save();

        BookService bookService = (BookService) context.getBean("bookService");
        bookService.save();

        BookDao bookDao1 = (BookDao) context.getBean("bookDao");
        BookDao bookDao2 = (BookDao) context.getBean("bookDao");
        System.out.println(bookDao1 == bookDao2);       // 可以看出 bean是单例的，只能创建一个对象
// 想要创建非单例的bean，那么需要在xml中配置
// <bean id="bookDao" name="dao" class="ssm.dao.impl.BookDaoImpl" scope="prototype"/>
// scope属性：prototype（非单例）和singleton(单例)，默认为singleton
    }
}
```
```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
  xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">
  <!---->
  <!--配置IoC容器中的bean-->
  <bean id="bookDao" class="ssm.dao.impl.BookDaoImpl"/>
  <bean id="bookService" class="ssm.service.impl.BookServiceImpl">
    <!--配置service与dao的关系-->
        <!-- setter方法注入对象  -->
    <!--property表示配置当前bean的属性 name属性表示配置哪一个具体的属性 ref属性表示参照哪一个bean-->
    <property name="bookDao" ref="bookDao"/>	<!-- name属性对应setter方法的方法名，即setBookDao -->
    		<!-- 构造器方法注入对象 -->
    <constructor-arg name="bookDao1" ref="bookDao"/> 	<!-- 此处的name为构造方法的形参名字 -->
  </bean>

</beans>	
```
<a name="r7NNf"></a>
#### 实例化Bean
:::info

- 使用构造方式实例化bean, 给bean对象的实现类定义一个 空参的构造函数，每次实例化bean时都会调用该构造函数。
- 静态工厂实例化bean
- 实例工厂实例化bean
- 使用FactoryBean实例化
   - 使用场景：
      - 代理类的创建
      - 第三方框架整合
      - 复杂对象实例化等
:::
```java
// 定义factory工厂类
public class BookDaoFactory {
    public static BookDao getBookDao() {
        System.out.println("factory setup...");
        return new BookDaoImpl();
    }
}
```
```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
  xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">
  <!--方式二：使用静态工厂实例化bean-->															<!-- 绑定具体实例化方法 -->
  <bean id="bookDaoFactory" class="ssm.dao.factory.BookDaoFactory" factory-method="getBookDao"/>
</beans>
```
```java
public class BookDaoFactory {
    public BookDao getBookDaoImpl() {			// 非静态
        System.out.println("factory setup...");
        return new BookDaoImpl();
    }
}
```
```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
  xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">
	<!--方式三：使用实例工厂实例化bean-->
  <bean id="bookFactory" class="ssm.dao.factory.BookDaoFactory"/> <!-- 因为是动态工厂，所以要先造工厂的实例对象 -->
  <bean id="bookDaoFactory" factory-bean="bookFactory" factory-method="getBookDaoImpl"/>  <!-- 然后再引用,注意getBookDaoImpl方法不是静态的 -->
</beans>
```
```java
// 定义一个 类 使他继承 FactoryBean这个接口并实现里面的方法
public class BookDaoFactoryBean implements FactoryBean<BookDao> {

    // 代替原始工厂中创建实例的方法
    @Override
    public BookDao getObject() throws Exception {
        return new BookDaoImpl();
    }

    // 这个bean是什么类型的
    @Override
    public Class<?> getObjectType() {
        return BookDao.class;
    }

    // 创建的对象是否为单例
    @Override
    public boolean isSingleton() {
        return true;        // true为单例，false为非单例
    }
}

```
```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">
		<!--方式四：使用FactoryBean实例化-->
    <bean id="bookDaoFactoryBean" class="ssm.dao.factory.BookDaoFactoryBean"/>
</beans>
```
<a name="OLKMn"></a>
#### 自动装配
```java
public class BookServiceImpl implements BookService {
    private BookDao bookDao;			// 按类型装配会自动获取bookDao的类型

    public void save() {
        System.out.println("book service save ...");
        bookDao.save();
    }

    public void setBookDao(BookDao bookDao) {
        this.bookDao = bookDao;
    }
}
```
```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">

    <!--按类型自动装配bean-->
    <bean id="bookDao" name="dao" class="ssm.dao.impl.BookDaoImpl"/>
        <!--按类型装配会自动装配BookServiceImpl类中的bookDao，而bookDao的实例化又会自动调用上一行-->
    <bean id="bookService" class="ssm.service.impl.BookServiceImpl" autowire="byType"/>
</beans>
```
<a name="n1UDx"></a>
#### spring加载properties文件
```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xsi:schemaLocation="
                    http://www.springframework.org/schema/beans
                    http://www.springframework.org/schema/beans/spring-beans.xsd
                    http://www.springframework.org/schema/context
                    http://www.springframework.org/schema/context/spring-context.xsd">
    <!-- 1.开启context命名空间,即 第四、八、九行-->
    <!-- 2.使用context命名空间加载properties文件-->
          <!-- 加载单个配置文件 -->
    <context:property-placeholder location="application.properties"/>
          <!-- 加载多个配置文件：location属性的值用,分割多个配置文件的地址 -->
    <!--使用属性占位符${}读取properties中的属性 -->
    <bean id="dataSource" class="com.alibaba.druid.pool.DruidDataSource">
        <property name="driver" value="${spring.datasource.driver-class-name}"/>
        <property name="url" value="${spring.datasource.url}}"/>
        <property name="username" value="${spring.datasource.username}"/>
        <property name="password" value="${spring.datasource.password}"/>
    </bean>
</beans>
```
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/mybatis
spring.datasource.username=root
spring.datasource.password=zzy0927
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
```
<a name="KIvI5"></a>
#### 注解开发
```java
@Component("bookDao")	// @Component注解相当于在配置文件里配置了一个 id=bookDao 的 bean
public class BookDaoImpl implements BookDao {
    public void save() {
        System.out.println("book dao save ... ");
    }
}

@Component
public class BookServiceImpl implements BookService {
    private BookDao bookDao;

    public void save() {
        System.out.println("book service save ...");
        bookDao.save();
    }
}

// 配置类SpringConfig
@Configuration          		 // 相当于一个配置文件
@ComponentScan({"ssm", "dao"})   // 扫描哪个包的组件,当扫描一个包时 @ComponentScan("ssm");
public class SpringConfig {

}

@SpringBootApplication
public class SsmApplication {
    public static void main(String[] args) {
        // 加载配置类
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        BookDao bookDao = (BookDao) context.getBean("bookDao");
        System.out.println(bookDao);
        BookService bookService = context.getBean(BookService.class);
        System.out.println(bookService);

    }
}
```
<a name="TgdFH"></a>
#### 自动装配
:::info
注解@Autowired自动匹配IoC容器中的对象，利用了暴力反射
:::
```java
@Configuration          // 相当于一个配置文件
@ComponentScan("ssm")   // 扫描哪个包的组件
@PropertySource("classpath:jdbc.properties")	// 加载配置文件，classpath: 加不加都可以
public class SpringConfig {		// 配置类

}

@Repository				// 数据层注解，内部封装了@Component
public class BookDaoImpl implements BookDao {
    public void save() {
        System.out.println("book dao save ... ");
    }
}

@Repository("BookDao2")	// 可以直接bean对象指定名称
public class BookDaoImpl2 implements BookDao {
    public void save() {
        System.out.println("book dao save ... ");
    }
}

@Service
public class BookServiceImpl implements BookService {

    @Autowired					// 暴力反射，从IoC容器中寻找BookDao的实现类
    @Qualifier("BookDao2")		// 当容器中有多个 实现类对象时，指定名实现类名称
    private BookDao bookDao; 

    @Value("${name}")			// 自动装配基本数据类型对象，从 配置文件中加载数据
    private String name;

    public void save() {
        System.out.println("book service save ..." + name);
        bookDao.save();
    }
}
```
<a name="IipAs"></a>
#### 管理第三方bean
```java
public class JdbcConfig {
    // 在一个方法上加上@Bean注解管理第三方bean
    @Bean
    // 因为dataSource类已经交给SpringConfig类管理，那么SpringConfig类加载了配置文件，那么dataSource类可以直接读取
    public DataSource dataSource(@Value("${name}") String name) { 
        System.out.println(name);
        DruidDataSource ds = new DruidDataSource();
        ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
        ds.setUrl("jdbc://mysql:localhost:3306/mybatis");
        ds.setUsername("root");
        ds.setPassword("zzy0927");
        return ds;
    }
}

@Configuration          
@ComponentScan("ssm")   
@PropertySource("classpath:jdbc.properties")
@Import(JdbcConfig.class)	// 在配置类中导入刚才管理的bean
public class SpringConfig {

}

@SpringBootApplication
public class SsmApplication {		// 简单使用
    public static void main(String[] args) {
        // 加载配置类
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        JdbcConfig jdbcConfig = context.getBean(JdbcConfig.class);
        System.out.println(jdbcConfig);
    }
}
```
<a name="xStZN"></a>
#### 整合Spring5-Test搭建测试环境
```java
// locations指定配置文件 , value指定配置类
@SpringJUnitConfig(value = JavaConfig.class)
public class SpringIocTest {

    @Autowired
    private A a;

    @Test
    public void test() {
        // ioc容器
        // 读取组件
            // 使用 @SpringJUnitConfig注解后不用再去获取IoC容器以及读取bean对象，可直接使用
        // 使用组件
        System.out.println(a);
    }
}
```
<a name="ZFdIm"></a>
## AOP切面编程
