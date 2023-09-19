package CollectionDemo;
import java.util.ArrayList;
import java.util.List;
// 通配符界限


/*
    1. 在实例化对象的时候，不确定泛型参数的具体类型时，可以使用通配符进行对象定义
    2. <? extends Object>代表上边界限定通配符
    3. <? super Object>代表下边界限定通配符。

    通配符上限 add() 方法收到限制，但是可以用来获取各种数据类型的数据，并赋值给父类型的引用。
    List<? extends Number> list=null;
    list=new ArrayList<Integer>();
    list.add(new Integer(1)); // 报错，因为 list不能确定实例化的对象具体类型导致 add()方法受限,
                                 因为 add 方法底层使用的是往 Object[] 数组中添加数据，
                                 编译器要确定元素的具体类型，以便在编译时检查类型的正确性，
                                 但是使用通配符上限后元素的类型是不确定的，所以编译器无法确定添加的元素是否符合泛型类型所规定的上限。
    ...
    list.get(0);//正确
 */

// 通配符上限用法
class GenericUpLimit {
    public static void main(String[] args) {
        firstPrint();
        secondPrint();
    }

    public static void firstPrint() {
        List<Float> list1 = new ArrayList<>();//使用 Float作实参类型
        list1.add(12.3f);
        list1.add(23.4f);
        print(list1);
    }

    public static void secondPrint() {
        List<Integer> list2 = new ArrayList<>();//使用Integer作实参类型
        list2.add(1);
        list2.add(2);
        list2.add(3);
        print(list2);
    }

    public static void print(List<? extends Number> list) {// 通配符作形参
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));// 使用get方法
        }
    }
}

// 通配符下限用法
/*
    通配符下限：存储数据时数据类型只能是当前类，或是当前类的子类, 取数据时只能使用 Object 类型接收数据
    不用父类接受数据的原因：当我们使用通配符下限获取列表中的元素时，
                        虽然我们知道元素的类型是 Integer或其父类，但由于 Java泛型中的类型擦除机制，
                        编译器无法确定具体类型，因此这个元素的类型会被擦除为 Object类型，
                        编译器只能依靠运行时的类型检查来确保类型安全。
    List<? super Integer> list = null;
    list = new ArrayList<Number>();
    list.add(1);
    Number number = list.get(0);
    ...
    list.add(1);//正确， 因为 不管是添加的不是 自己的类型，就是父类的类型。
*/
class GenericDownLimit {
    public static void main(String[] args) {
        List<? super Number> list = new ArrayList<>();
        firstInflate(list);
        for (int i = 0; i < list.size(); i++) {
            Object o = list.get(i);
            System.out.println(o);
        }
        list.clear();
        secondInflate(list);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    public static void firstInflate(List<? super Integer> list) {// 装填整数
        list.add(1);
        list.add(2);
        list.add(3);
    }

    public static void secondInflate(List<? super Float> list) {// 装填浮点数
        list.add(1.1f);
        list.add(2.2f);
        list.add(1.3f);
    }
}


public class GenericLimit {
    public static void main(String[] args) {
    }
}
