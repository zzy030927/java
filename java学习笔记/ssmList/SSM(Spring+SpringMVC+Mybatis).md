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
### IoC	
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
### IoC初步使用 - xml配置
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
### DI初步使用 - xml配置
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
### 实例化Bean
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
### 自动装配
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
### spring加载properties文件
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
### 注解开发
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
### 自动装配
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
### 管理第三方bean
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
### 整合Spring5-Test搭建测试环境
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
## AOP面向切面编程
<a name="fXeyC"></a>
### 概述
```java
public interface Cal {
    int add(int i, int j);
    int sub(int i, int j);
    int mul(int i, int j);
    int div(int i, int j);
}
```
```java
public class CalImpl implements Cal {

    @Override
    public int add(int i, int j) {
        System.out.println("i = " + i + ", j = " + j);
        int res = i + j;
        System.out.println("res = " + res);
        return res;
    }

    @Override
    public int sub(int i, int j) {
        System.out.println("i = " + i + ", j = " + j);
        int res = i - j;
        System.out.println("res = " + res);
        return res;
    }

    @Override
    public int mul(int i, int j) {
        System.out.println("i = " + i + ", j = " + j);
        int res = i * j;
        System.out.println("res = " + res);
        return res;
    }

    @Override
    public int div(int i, int j) {
        System.out.println("i = " + i + ", j = " + j);
        int res = i / j;
        System.out.println("res = " + res);
        return res;
    }
}
```
:::info
代码缺陷：

- 可以看出，每个实现方法都是先对 i 和 j 进行打印，进行计算，然后输出计算结果之后返回，代码有大量的重复，冗余同时不方便维护。
- 对核心业务有干扰

解决思路：

- 解耦，将附加功能从业务实现代码中抽离出来
- 将重复的代码抽离出来同时统一 动态插入 到每个函数相应的位置
:::
<a name="vN3DV"></a>
### 代理
:::info
代理：将非核心的逻辑抽离出来以后，封装这些非核心逻辑的类、方法、对象。<br />目标：被代理“套用”了核心逻辑代码的类、对象、方法。
:::
<a name="sl09E"></a>
#### 静态代理
:::info
静态代理创建一个代理类，在类中去引入被代理的类，然后再在每个方法中添加非核心逻辑代码。
:::
```java
// 静态代理
public class StaticProxyCal implements Cal {

    // 传入需要被代理的类
    private Cal cal;

    // 使用构造函数传入目标
    public StaticProxyCal(Cal cal) {
        this.cal = cal;
    }

    @Override
    public int add(int i, int j) {
        // 非核心业务代码
        System.out.println("i = " + i + ", j = " + j);
        // 核心业务代码
        int res = cal.add(1, 1);
        System.out.println("res = " + res);
        return res;
    }
}
```
```java
public class UserAop {
    public static void main(String[] args) {
        Cal cal = new CalImpl();
        StaticProxyCal proxyCal = new StaticProxyCal(cal);
        proxyCal.add(1, 1);
    }
}
```
<a name="WQ51t"></a>
#### 动态代理
:::info
动态代理技术划分:

- JDK动态代理：JDK原生的实现方式，需要被代理的目标类必须是实现接口，它会根据目标类的接口动态生成一个代理对象，代理对象和目标对象有相同的接口。
- cglib动态代理：通过继承被代理的目标类实现代理，所以必须要被代理类实现接口。
:::
```java
public class JdkProxyCal {
    private final Object target;

    public JdkProxyCal(Object target) {
        this.target = target;
    }

    public Object getProxy(){

        /*
         * newProxyInstance()：创建一个代理实例
         * 其中有三个参数：
         * 1、classLoader：加载动态生成的代理类的类加载器
         * 2、interfaces：目标对象实现的所有接口的class对象所组成的数组
         * 3、invocationHandler：设置代理对象实现目标对象方法的过程，即代理类中如何重写接口中的抽象方法
         */
        ClassLoader classLoader = target.getClass().getClassLoader();       // 类加载器
        Class<?>[] interfaces = target.getClass().getInterfaces();          // 所有接口
        InvocationHandler invocationHandler = new InvocationHandler() {     // 抽象出来的过程
            // invoke(): 调用代理的方法都会执行此方法
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                /*
                 * proxy：代理对象
                 * method：代理对象需要实现的方法，即其中需要重写的方法
                 * args：method所对应方法的参数
                 */
                Object result = null;
                try {
                    System.out.println("[动态代理][日志] "+method.getName()+"，参数："+ Arrays.toString(args));
                    // 调用目标方法进行核心业务
                    result = method.invoke(target, args);
                    System.out.println("[动态代理][日志] "+method.getName()+"，结果："+ result);
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("[动态代理][日志] "+method.getName()+"，异常："+e.getMessage());
                } finally {
                    System.out.println("[动态代理][日志] "+method.getName()+"，方法执行完毕");
                }
                return result;
            }
        };
        return Proxy.newProxyInstance(classLoader, interfaces, invocationHandler);
    }
}
```
```java
public class Test {
    public static void main(String[] args) {
        // 确定要被代理的对象
        Cal cal = new CalImpl();
        // jdk代理
        JdkProxyCal factory = new JdkProxyCal(cal);
        // getProxy()获取代理对象，类型为Cal的实现类
        Cal proxy = (Cal) factory.getProxy();
        proxy.add(1, 1);
    }
}
```
<a name="enb4z"></a>
### 面向切面编程思维AOP
:::info
AOP：Aspect Oriented Programming面向切面编程<br />AOP可以说是OOP（Object Oriented Programming，面向对象编程）的补充和完善。OOP引入封装、继承、多态等概念来建立一种对象层次结构，用于模拟公共行为的一个集合。不过OOP允许开发者定义纵向的关系（继承父类，super使用父类或重写父类，但不能局部修改父类的方法），但并不适合定义横向的关系（解剖开封装对象内部，把多个方法中重复的代码提取到一个公共模块，利用动态代理技术，把公共模块插入进去，减少非核心业务代码的编写），例如日志功能。日志代码往往横向地散布在所有对象层次中，而与它对应的对象的核心功能毫无关系对于其他类型的代码，如安全性、异常处理和透明的持续性也都是如此，这种散布在各处的无关的代码被称为横切（cross cutting），在OOP设计中，它导致了大量代码的重复，而不利于各个模块的重用。
:::
<a name="zdGs8"></a>
### AOP名词
:::info

- 横切关注点
   - AOP把软件系统分为两个部分：核心关注点和横切关注点。业务处理的主要流程是核心关注点，与之关系不大的部分是横切关注点。横切关注点的一个特点是，他们经常发生在核心关注点的多处，而各处基本相似，比如权限认证、日志、事务、异常等。AOP的作用在于分离系统中的各种关注点，将核心关注点和横切关注点分离开来。
- 通知：每一个横切关注点上要做的事情都需要写一个方法来实现，这样的方法就叫通知方法。
   - 前置通知：在被代理的目标方法前执行
   - 返回通知：在被代理的目标方法成功结束后执行（**寿终正寝**）
   - 异常通知：在被代理的目标方法异常结束后执行（**死于非命**）
   - 后置通知：在被代理的目标方法最终结束后执行（**盖棺定论**）
   - 环绕通知：使用try...catch...finally结构围绕整个被代理的目标方法，包括上面四种通知对应的所有位置
- 连接点：指那些被拦截到的点。在 Spring 中，可以被动态代理拦截目标类的方法
- 切入点 pointcut：定位连接点的方式，或者可以理解成被选中的连接点！
- 切面 aspect：切入点和通知的结合。是一个类。
- 目标 target：被代理的目标对象。
- 代理 proxy：向目标对象应用通知之后创建的代理对象。
- 织入 weave：指把通知应用到目标上，生成代理对象的过程（切入的动作）。可以在编译期织入，也可以在运行期织入，Spring采用后者。
:::
<a name="wOhIw"></a>
### 注解开发aop
:::info
手动编程做代理太繁琐，所以可以用spring AOP框架，用注解或者xml配置实现代理。<br />注意：aop只能对ioc容器对象，只为ioc容器对象创建代理对象，同时将代理对象存储在ioc容器中
:::
<a name="JuMWr"></a>
#### Spring AOP底层技术组成
              ![image.png](https://cdn.nlark.com/yuque/0/2023/png/35506053/1696324958520-d86e080f-08eb-4f8d-b9e5-2ce8fb8fff63.png#averageHue=%23101010&clientId=u60b31375-6086-4&from=paste&height=445&id=u2a80df4f&originHeight=556&originWidth=700&originalType=binary&ratio=1.25&rotation=0&showTitle=false&size=42694&status=done&style=none&taskId=u2fb91d4b-84af-4742-b252-2b2bc7210c7&title=&width=560)
:::info

- 动态代理（InvocationHandler）：JDK原生的实现方式，需要被代理的目标类必须实现接口。因为这个技术要求代理对象和目标对象实现同样的接口（兄弟两个拜把子模式）。
- cglib：通过继承被代理的目标类（认干爹模式）实现代理，所以不需要目标类实现接口。
- AspectJ：早期的AOP实现的框架，SpringAOP借用了AspectJ中的AOP注解。
:::
<a name="fnIfo"></a>
#### 使用
```java
@Configuration
@ComponentScan("com.src")
@EnableAspectJAutoProxy // 开启Aspectj注解
public class JavaConfig {
}

```
```java
// 增强类
/*
*   1. 定义增强方法
*       具体定义几个方法，根据插入位置决定。
*   2. 使用注解配置，加对应注解使得插入目标方法的位置
*       前置 @Before
*       后置 @AfterReturning
*       异常 @AfterThrowing，在 catch() {} 中使用
*       最后 @After
*       环绕 @Around
*    3. 配置切入点表达式：即选择要插入的方法，即选择切点
*
*    4. 补全注解
*        加入ioc容器 @Component
*        配置切面 @Aspect
*
*    5. 开启aspect注解支持
*        可以在配置文件和配置类中配置
*        配置文件：<aop:aspectj-autoproxy/>
*        配置类：@EnableAspectJAutoProxy
* */
@Component
@Aspect     // 此注解表示LogAdvice为切面类
public class LogAdvice {
        	// 切点表达式：用于寻找目标方法
    @Before("execution(* com.src.service.impl.*.*(..))")
    public void pre() {
        System.out.println("方法开始执行");
    }

    @After("execution(* com.src.service.impl.*.*(..))")
    public void after() {
        System.out.println("方法结束了");
    }

    @AfterThrowing("execution(* com.src.service.impl.*.*(..))")
    public void error() {
        System.out.println("方法报错了");
    }
}
```
```java
// aop只能对ioc容器对象，只为ioc容器对象创建代理对象，同时将代理对象存储在ioc容器中
@Service
public class CalImpl implements Cal {

    @Override
    public int add(int i, int j) {
        System.out.println("执行add()方法");
        int res = i + j;
        System.out.println("res = " + res);
        return res;
    }

    @Override
    public int sub(int i, int j) {
        int res = i - j;
        return res;
    }

    @Override
    public int mul(int i, int j) {
        int res = i * j;
        return res;
    }

    @Override
    public int div(int i, int j) {
        int res = i / j;
        return res;
    }
}

```
```java
@SpringJUnitConfig(value = JavaConfig.class)
public class SpringAopTest {

    // 如果需要代理的类有接口，那么会选择jdk代理，生成一个接口的代理类对象。
    // 如果没有接口，那么会用cglib代理，继承这个类。
    @Autowired
    private Cal cal;

    @Test
    public void test() {
        cal.add(1, 1);
    }
}
```
<a name="iXqXd"></a>
##### 切点表达式总结
:::info
如果不考虑访问修饰符和方法返回值，那么可以用 * 代替，如果仅不考虑其中一个，那么不能用 * 代替

- 单层模糊：指定包时 com.dao.impl.*，即：com包下的dao包下的impl包下的任意包
- 多层模糊：指定包时 com..impl，即：com包下的任意包下的impl， .. 不能用于开头，*..impl为寻找任意包下的impl包
- 参数列表部分模糊：(String..) 表示第一个参数String，后面的随便 。（..int）表示最后一个参数为int
:::
![image.png](https://cdn.nlark.com/yuque/0/2023/png/35506053/1696336501134-d1a673a9-8245-4383-a9d0-e65146a7226b.png#averageHue=%23000000&clientId=u60b31375-6086-4&from=paste&height=425&id=EvlF0&originHeight=531&originWidth=1781&originalType=binary&ratio=1.25&rotation=0&showTitle=false&size=107354&status=done&style=none&taskId=u3667b2c8-57f4-4ae0-90ec-b5ba44dc4eb&title=&width=1424.8)
<a name="W7ofS"></a>
##### 提取公共的切点表达式
:::info
建议单独创建一个切点的类，用于单独维护切点表达式，下面的代码没有创建单独的切点类。该类也要放在ioc容器中。
:::
```java
// 切入点表达式重用
// 提取切点注解使用@Pointcut(切点表达式) ， 需要添加到一个无参数无返回值方法上即可！
public class LogAspect {
    @Pointcut("execution(public int com.src.aop.api.Calculator.add(int,int)))")
    public void declarPointCut() {}
    
    @Before(value = "declarPointCut()")		// 引用提取的切点表达式
    public void printLogBeforeCoreOperation(JoinPoint joinPoint) {
    
    }
}
```
```java
// 引用不同包中的切点表达式
public class Ref {
    // 包名+类名+方法名	
    @Before(value = "com.src.dao.LogAspect.declarPointCut()")
    public Object roundAdvice(ProceedingJoinPoint joinPoint) {
    }
}
```

<a name="GuaMM"></a>
#### 获取被代理类的信息
```java
/*
* 在此类中获取目标方法的全部信息，包括获取方法名，参数，访问修饰符，或者所属的类的信息
* 获取返回结果，只在afterReturning中有效
* 获取异常信息，只在afterThrowing中有效
*  */
@Aspect
@Component
public class MethodAdvice {

    // 目标执行前
    @Before("execution(* com.src.service.impl.*.*(..))")
    public void before(JoinPoint joinPoint) {   // JointPoint 为目标方法类的封装对象
        // 1.获取方法所属类的信息 - jointPoint.getTarget()获取目标类，之后反射
        String className = joinPoint.getTarget().getClass().getSimpleName();
        // 2.获取目标方法名称 joinPoint.getSignature() 获取方法的详细信息
        String methodName = joinPoint.getSignature().getName();
        // 3.获取参数列表
        Object[] args = joinPoint.getArgs();
        System.out.println("className = "+className+ " methodName = " + methodName + " args =" + Arrays.toString(args));
    }

    // 目标正常执行完毕后执行
    @AfterReturning(value = "execution(* com.src.service.impl.*.*(..))", returning = "res")
    public void afterReturning(JoinPoint joinPoint, Object res) {    // res用于接受返回值
        System.out.println("返回的结果为: " + res);
    }

    // 最后目标报不报错都会执行
    @After("execution(* com.src.service.impl.*.*(..))")
    public void after(JoinPoint joinPoint) {

    }

    // 目标执行时报错
    @AfterThrowing(value = "execution(* com.src.service.impl.*.*(..))", throwing = "e")
    public void error(JoinPoint joinPoint, Throwable e) {       // Throwable用于接受异常信息
//        System.out.println(e.getMessage());
    }
}
```
<a name="iX5jo"></a>
#### 环绕通知
:::info
环绕通知对应整个 try...catch...finally 结构，包括前面四种通知的所有功能。
:::
```java
public class Around {
    // 使用@Around注解标明环绕通知方法
    // 使用到了切点类中的切点表达式
    @Around(value = "com.src.aop.aspect.PointCut.transactionPointCut()")
    public Object manageTransaction(
            // 通过在通知方法形参位置声明ProceedingJoinPoint类型的形参，
            // Spring会将这个类型的对象传给我们
            ProceedingJoinPoint joinPoint) {
        
        // 通过ProceedingJoinPoint对象获取外界调用目标方法时传入的实参数组
        Object[] args = joinPoint.getArgs();
        
        // 通过ProceedingJoinPoint对象获取目标方法的签名对象
        Signature signature = joinPoint.getSignature();
        
        // 通过签名对象获取目标方法的方法名
        String methodName = signature.getName();
        
        // 声明变量用来存储目标方法的返回值
        Object targetMethodReturnValue = null;
        
        try {
        
            // 在目标方法执行前：开启事务（模拟）
            log.debug("[AOP 环绕通知] 开启事务，方法名：" + methodName + "，参数列表：" + Arrays.asList(args));
        
            // 过ProceedingJoinPoint对象调用目标方法
            // 目标方法的返回值一定要返回给外界调用者
            targetMethodReturnValue = joinPoint.proceed(args);
        
            // 在目标方法成功返回后：提交事务（模拟）
            log.debug("[AOP 环绕通知] 提交事务，方法名：" + methodName + "，方法返回值：" + targetMethodReturnValue);
        
        }catch (Throwable e){
        
            // 在目标方法抛异常后：回滚事务（模拟）
            log.debug("[AOP 环绕通知] 回滚事务，方法名：" + methodName + "，异常：" + e.getClass().getName());
        
        }finally {
        
            // 在目标方法最终结束后：释放数据库连接
            log.debug("[AOP 环绕通知] 释放数据库连接，方法名：" + methodName);
        
        }
        
        return targetMethodReturnValue;
    }
}
```
<a name="Sxzpe"></a>
#### 切面优先级
:::info
相同目标方法上同时存在多个切面时，切面的优先级控制切面的内外嵌套顺序。

- 优先级高的切面：外面
- 优先级低的切面：里面 

使用 @Order 注解可以控制切面的优先级：

- @Order(较小的数)：优先级高
- @Order(较大的数)：优先级低

                         ![image.png](https://cdn.nlark.com/yuque/0/2023/png/35506053/1696340543528-121869c2-643a-45f8-a9f6-c5964b87ec53.png#averageHue=%23000000&clientId=u60b31375-6086-4&from=paste&height=326&id=ue8b78b26&originHeight=570&originWidth=861&originalType=binary&ratio=1.25&rotation=0&showTitle=false&size=44357&status=done&style=none&taskId=u9dc84423-e567-412e-83aa-e21465203f6&title=&width=491.79998779296875)
:::
<a name="DCuqM"></a>
### xml开发aop
```xml
<!-- 配置目标类的bean -->
<bean id="calculatorPure" class="com.src.aop.imp.CalculatorPureImpl"/>

<!-- 配置切面类的bean -->
<bean id="logAspect" class="com.src.aop.aspect.LogAspect"/>

<!-- 配置AOP -->
<aop:config>

  <!-- 配置切入点表达式 -->
  <aop:pointcut id="logPointCut" expression="execution(* *..*.*(..))"/>

  <!-- aop:aspect标签：配置切面 -->
  <!-- ref属性：关联切面类的bean -->
  <aop:aspect ref="logAspect">
    <!-- aop:before标签：配置前置通知 -->
    <!-- method属性：指定前置通知的方法名 -->
    <!-- pointcut-ref属性：引用切入点表达式 -->
    <aop:before method="printLogBeforeCore" pointcut-ref="logPointCut"/>

    <!-- aop:after-returning标签：配置返回通知 -->
    <!-- returning属性：指定通知方法中用来接收目标方法返回值的参数名 -->
    <aop:after-returning
      method="printLogAfterCoreSuccess"
      pointcut-ref="logPointCut"
      returning="targetMethodReturnValue"/>

    <!-- aop:after-throwing标签：配置异常通知 -->
    <!-- throwing属性：指定通知方法中用来接收目标方法抛出异常的异常对象的参数名 -->
    <aop:after-throwing
      method="printLogAfterCoreException"
      pointcut-ref="logPointCut"
      throwing="targetMethodException"/>

    <!-- aop:after标签：配置后置通知 -->
    <aop:after method="printLogCoreFinallyEnd" pointcut-ref="logPointCut"/>

    <!-- aop:around标签：配置环绕通知 -->
    <!--<aop:around method="……" pointcut-ref="logPointCut"/>-->
  </aop:aspect>

</aop:config>

```
