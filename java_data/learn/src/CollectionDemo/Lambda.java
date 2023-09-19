package CollectionDemo;

interface Sub{  // 一个接口中只有一个方法，那么这个接口就被称为函数式接口，那么才可以使用 Lambda 表达式
    void add1();
}

interface Sum{  // 这个接口不能使用 Lambda 表达式实现
    void add();
    void mul();
}

interface Test1{
    void pri(String name);
}

interface Test2{
    int abs1(int a);
}

// Lambda 是一个特殊的匿名类
public class Lambda {
    public static void main(String[] args) {
        System.out.println("----无参----");
        Sub num = () -> {   // Lambda 的使用
            System.out.println("1");
        };
        num.add1();

        System.out.println("----有参----");
        Test1 test = (name) -> {    // 这里的参数要和接口中函数的 参数名字 相同
            System.out.println(name);
        };
        test.pri("zhang");  // 在这里进行传参

        System.out.println("----引用其它类中的静态方法---");

    }

}
