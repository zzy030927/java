package student.learn_java;
// object : 对象
// Object 类 是所有类 的 公共的 父类
// 类 Object， 所有对象(包括数组)都实现这个类的方法

// Object 类常用方法: 下述方法都可以重写
// toString() : 默认返回 @地址 的格式，用来展示对象的地址
// hashCode() : 用于获取对象的散列值，返回的是对象的堆内存地址
// equals() : 比较两个对象，相同返回 true
// clone() : 浅拷贝
// finalize() : 对象的垃圾回收器

class Person
{
    private String name;
    private int age;
    private double salary;
    private String addr;
    public Person(){};
    public Person(String name, int age, double salary, String addr)
    {
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.addr = addr;
    }
    public String toString(String name, int age, int salary, String addr)   // 重写 toString() 函数
    {
        return "Person [name = " + name + ", age = " + age + ", salary = " + salary + ", addr = " + addr + "]";
    }

}

public class object
{
    public static void main(String[] args)
    {
        Person p1 = new Person("zhang", 20, 10, "cangzhou");
        System.out.println(p1.toString());   // 返回地址
        System.out.println(p1.toString("zhang", 20, 10, "cangzhou")); // 返回重写内容

        Person p2 = new Person("liu", 21, 12, "cangzhou");
        System.out.println(p1.equals(p2));  // 判断两个对象是否相等

        System.out.println(p1.hashCode());  // 返回对象的 哈希地址
    }
}
