package student.learn_java;

//接口
//接口关键字用 interface 修饰
// 类实现接口用 implements 表示
//接口不能实例化

//接口如何实例化呢？参照多态的方式，通过实现类对象实例化，这叫接口多态。

//多态的形式：具体类多态，抽象类多态，接口多态。

//接口的子类
// 要么重写接口中的所有抽象方法
// 要么子类也是抽象类

//12.3 接口的成员特点
//成员特点
//成员变量
// 只能是常量
// 默认修饰符：public static final, 系统会默认加上

//构造方法
//没有，因为接口主要是扩展功能的，而没有具体存在

//成员方法
//只能是抽象方法
//默认修饰符：public abstract

//如果父类实现了接口中的全部方法，那么子类不必使用 implements 继承这个接口。

interface In
{
    public final static int a = 4;     // 默认 public final static，一旦出现静态变量和函数就不是接口内部的变量和函数，因为它是静态的
    int b = 5;
    // b = 4;
    public String name=  "1";
    int c = 2;


    // 静态方法只能通过 接口名.静态方法 来调用，不能通过对象名或者实现类名来调用，并且静态方法不用被实现类重写
    public static void pr(){ System.out.println("静态方法: " +123);};
    default void pr1(){System.out.println("默认方法: " +456);};       // 默认方法，不强制子类去复写父类的 静态方法和默认方法，但是可以被调用
    // 普通私有方法
    private void pr2() {
        System.out.println("接口中的普通私有方法");
    }

    // 静态私有方法
    private static void pr3() {
        System.out.println("接口中静态私有方法");
    }

    default void pr4() {
        pr2();
        pr3();
    }

    void display(); // 抽象方法，默认 public abstract
    void In();      // 不是构造函数
}

interface In1
{

}

class te
{

}

// 类继承接口
// abstract class Im extends te implements In 先继承类后继承接口
class Im implements In,In1  // 接口可多继承
{
    public void display()
    {
        // name = "1"; 不可修改
        System.out.println(name);   // 子类可以访问
    }
    public void In()
    {
        System.out.println("In构造");
    }
}

// 接口回调 : 有个接口 A， A 有个实现类 Almpl, 而 Almpl 中 有两个方法 a() 和 c(),
// 有个 B 类， B类中有个方法 b()，
// 接口回调就是 Almpl 类中通过方法 a() 调用 B类中的 方法 b() ,在方法 b() 中 有回调 Almpl 类中的 方法 c()

// 同步回调 : 方法 b() 的逻辑执行完再去执行方法 c()
// 异步回调 : 方法 b() 和 方法 c() 一起执行

interface CallBack  // 接口 A
{
    boolean consider(int money);// 收到钱后的思考方式
    void payFor(int money);     // 思考要不要付钱
}

class Passenger_Impl implements CallBack    // 实现类 Almpl
{
    public boolean consider(int money)
    {
        boolean result = true;
        if(money > 60)
        {
            result = false;
            System.out.println(money + "太贵了");
        }
        return result;
    }

    public void payFor(int money)           // c() 方法
    {
        System.out.println("OK, " + money + "给你");
    }

    public void takeTaxi(Driver driver)         // a() 方法
    {
        System.out.println("师傅, 去北京一天多少钱");
        driver.answer(this);            // 把本类传递给 B 类中的 b() 方法
    }
}

class Driver
{
    public void answer(CallBack callBack)
    {
        System.out.println("去北京60");
        if(callBack.consider(60))
        {
            callBack.payFor(60);       // 回调 Almpl 类中的 c() 方法
        }
    }
}

public class Interface
{
    public static void main(String[] args)
    {
        In i = new Im();    // 接口没有构造函数,用多态访问变量和函数
        i.display();
        System.out.println("-------接口回调--------");
        Passenger_Impl passenger = new Passenger_Impl();
        Driver driver = new Driver();
        passenger.takeTaxi(driver);
        System.out.println("-------默认函数和静态变量--------");
        In in = new Im();
        in.pr1();     // 默认方法
        In.pr();      // 静态方法
        i.pr4();
        System.out.println("静态不可修改的变量: " + In.a +"," + In.b + "," + In.c + "," + In.name);
    }
}
//类与类的关系
// 继承关系，只能单继承，但是可以多层继承

//类与接口的关系
// 实现关系，可以单实现，也可以多实现，还可以在继承一个类的同时实现多个接口

//接口与接口的关系
// 继承关系，可以单继承，也可以多继承

//抽象类和接口的区别

//成员区别
//抽象类
// 变量,常量；有构造方法；有抽象方法,也有非抽象方法
//接口
// 常量；抽象方法

//关系区别
//类与类
// 继承，单继承

//类与接口
// 实现，可以单实现，也可以多实现

//接口与接口
// 继承，单继承，多继承

//设计理念区别
//抽象类
// 对类抽象，包括属性、行为

//接口
// 对行为抽象，主要是行为
