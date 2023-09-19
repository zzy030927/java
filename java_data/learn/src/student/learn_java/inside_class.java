package student.learn_java;

// 内部类，类中有一个类即内部类

//内部类可以直接访问外部类的成员，包括私有
//外部类要访问内部类的成员，必须创建对象
//局部内部类 : 即在一个类的 ”方法 “ 中定义一个类,可以直接访问外部的成员，不可以访问方法，不可以给成员值修改和赋值


class Outer // 该类中有 内部类 的 使用
{
    int number;
    private int age;
    class Inner
    {
//        static int a = 5;     jdk16 以下不支持 内部类声明静态变量和静态函数
        public String name;
        void setname(String name)
        {
            this.name = name;
        }
        void show()
        {
            age = 18;   // 内部类直接访问
            number = 3;
            System.out.println(age + " " + name);
        }
    }
    // name = "z"; 内部类外 不能直接访问
    void get()  // 内部类的使用
    {
        Inner in = new Inner();
        in.setname("zhang");
        in.show();
    }
}


class local_outer   // 该类中有 局部内部类 的 使用,局部外部类 外部 无法直接使用
{
    private int age;
    int number;
    int num = 3;
    int re()
    {
        return age;
    }
    void set(int age,int number)
    {
        this.age = age;
        this.number = number;
    }

    void get()  // 在本方法中实例化一个 外部类 对象，可以用此对象调用外部类的方法，变量。
    {
        int num = 20;
        local_outer loc = new local_outer();
        class local_inner_class
        {
            int num = 1;
            void play()
            {
                System.out.println("玩");
            };
            void show()
            {
                System.out.println(num);    //  自内向外逐级调用
                System.out.println(age);
                System.out.println(number);
                play();     // 可以调用局部内部类中的方法
                loc.set(12, 3);
            }
        }

        local_inner_class lo = new local_inner_class();
        lo.show();
        // lo.re(),lo.set(), age = 18; 都不可使用
    }

}

public class inside_class
{
    public static void main(String[] args)
    {
        System.out.println("-----内部类使用----");
        Outer ou = new Outer();
        ou.get();
        System.out.println("Outer Number = " + ou.number);  // 证明可以直接访问
        //外界创建成员内部类格式
        Outer.Inner inn = new Outer().new Inner();
        inn.setname("1111");
        inn.show();

        System.out.println("-----局部内部类使用----");
        local_outer loc = new local_outer();
        loc.set(18,1);
        loc.get();  // 局部内部类的使用
    }
}
