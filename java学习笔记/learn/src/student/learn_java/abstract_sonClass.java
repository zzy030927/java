package student.learn_java;
import java.lang.*;

//抽象类传参需要抽象子类
// 返回时返回的是抽象子类

//接口与抽象类传参、返回参数相似，
// 传入的是该接口的实现类对象
// 返回的的是该接口的实现类对象

/*
    抽象类与接口的区别：
        接口是特别的抽象类，
        抽象类中可以有抽象方法和普通方法， 接口中只允许有抽象方法。
        抽象类中可以有成员变量和常量， 接口中只能由 final static 静态不可修改变量
        抽象类中可以有构造函数，但是接口中没有构造函数

 */

abstract class Fa    // 抽象类
{
    public String name;
    abstract void eat();    //抽象方法
    public Fa(){};
    public Fa(String name)
    {
        this.name = name;
    };
}

class Son extends Fa
{
    public Son(){};
    public Son(String name)
    {
        super(name);
    }
    public void eat()
    {
        System.out.println(name + " 吃饭");
    }
    void sport()
    {
        System.out.println("运动");
    }
}

class FaAndSon
{
    void get(Fa fa)
    {
        fa.eat();
    }
    Fa re()
    {
        Fa f=  new Son();   // 返回的是子类对象
        return f;
    }
}

public class abstract_sonClass
{
    public static void main(String[] args)
    {
        Fa f = new Son("zhang");
        f.eat();

        FaAndSon F = new FaAndSon();
        F.get(f);

        Fa new_f = new Son();
        new_f = F.re(); //抽象父类用来接受子类对象
        new_f.eat();
    }
}
