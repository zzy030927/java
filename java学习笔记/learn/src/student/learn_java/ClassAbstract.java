package student.learn_java;
//抽象类
//当我们在做子类共性功能抽取时，有些方法在父类中并没有具体的体现，这个时候就需要抽象类了！
//在Java中，一个没有方法体的方法应该定义为抽象方法，而类中如果有抽象方法，该类必须定义为抽象类！
//抽象类中不一定有抽象方法，有抽象方法的类一定是抽象类

//抽象类不能实例化
//抽象类如何实例化呢？参照多态的方式，通过子类对象实例化，这叫抽象类多态

//成员的特点
//
//成员变量
//既可以是变量
//也可以是常量
//构造方法
//空参构造
//有参构造
//成员方法
//抽象方法
//普通方法

//抽象类的子类
//要么重写抽象类中的所有抽象方法
//要么是抽象类

//抽象子类的作用： 重写父类中的抽象方法，要么自己就是一个抽象类。


abstract class Ab
{
    public int a;
    public   String name = "111";
    public abstract void eat();
    public void Ab(){};
    public void Ab(int a){
        this.a = a;
    };
    public void teach()
    {
        System.out.println("教");
    }
}

class ab extends Ab
{
    public void eat()
    {
        System.out.println("吃");
    }
}


public class ClassAbstract
{
    public static void main(String[] args)
    {

    }
}
