package CollectionDemo;

import java.util.ArrayList;
import java.util.List;

// 泛型
class _Generic
{
    //     <T> 指明该方法使用到泛型 T
    //     返回值为泛型 T
    //     show(T t)   传递泛型 T
    public <T> T show(T t)
    {
        return t;
    }
}

class e<T>  // 默认 T 为 Object 类型
{

}
//子类 继承 泛型父类分两种情况
// 1.子类也是泛型
class f<T> extends e
{

}
// 2.子类不是泛型 父类必须声明 传入的参数是什么
class g extends e<String>
{

}

// 泛型接口, <T> 指定该接口为泛型接口
interface genericInterface<T>
{
    // <T1> 说明 show1 为泛型方法，如果说明这个方法为泛型方法,
    // 注意 t 使用的是 泛型方法传入的类型， t2使用的是泛型接口传入的类型,他们两个是不同的
    <T1>T1 show1(T1 t, T t2);
    void show2();
    T show3(T t);
}

// 继承 genericInterface接口
// 说明该类引用了 泛型方法， Impl<T>
// genericInterface<T> 继承了 接口 genericInterface
class Impl<T> implements genericInterface<T>
{
    public <T2>T2 show1(T2 t, T t1)
    {
        System.out.println(t1);
        return t;
    }
    public void show2() {}
    public T show3(T t)
    {
        return t;
    }
}

class c
{

}

class d extends c
{

}

public class generic
{
    public static void main(String[] args)
    {
        // ctrl + alt + v 自动生成一个适应的类型
        _Generic generic = new _Generic();
        String str = generic.show("str");
        System.out.println(generic.show("str"));
        System.out.println(generic.show(true));
        System.out.println(generic.show(213));
        System.out.println(generic.show("--------泛型接口---------"));
        Impl<Integer> objectImpl = new Impl<>();
        String str1 = objectImpl.show1("str1", 123);
        System.out.println(str1);
        System.out.println("--------通配符---------");
        ArrayList<String> strings = new ArrayList<>();
        ArrayList<Integer> integers = new ArrayList<>();
        printList(strings);
        printList(integers);
        ArrayList<?> objects = new ArrayList<>();
        // 可以接受所有的泛型类型
        // objects.add(); 不能用于添加数据
        System.out.println("---------泛型擦除机制--------");
        // 泛型原理，底层使用了 擦除机制
        // 泛型是在编译阶段限制传递的类型
        // 说明： 将一个 List 集合泛型 赋值给一个没有使用到泛型 List 集合，直接去除泛型 ----- 擦除机制
        List<String> str3 = new ArrayList<>();
        str3.add("123");
        // str3 只能添加 String 类型，因为 泛型规定了只能传入 String 类型
        List list = str3;
        // list 能传入任何类型的参数，因为 擦除机制，去除泛型，所以 list 能添加任何类型
        list.add("1");
        list.add("2345");
    }
    // ? 为通配符，可以接受所有的泛型类型
    // List<?> 只能用于接受数据，但是不能够用于添加数据
    public static void printList(List<?> list)
    {
        // list.add();
        // 报错
    }
    // (List<? extends Impl> list，通配符 ? extends Impl 使得 list 只能传入 Impl 类和他的子类， 这里的通配符 称为 通配符上限
    public void printList(List<? extends Impl> list, int a)
    {

    }

    // 这里的 List<? super d>list 称为 通配符下限，只能接受 类 d 与 它的父类
    public void printList1(List<? super d> list)
    {

    }

}