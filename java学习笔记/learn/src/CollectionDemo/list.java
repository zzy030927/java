package CollectionDemo;

import java.util.*;

// 集合 List
// 集合： 把具有相同元素的东西放在一起，也可以是容器。
// List: 是 java.util 下的一个接口，有序集合（也可以称为序列）。用户可以精准控制每个元素在列表的插入位置，
// 用户可以通过索引访问元素，并在列表中搜索元素。

// List 其继承了 Collection 接口并由 AbstractList 来实现，Collection 又继承了 Iterable 接口

// List 的 种类：List的种类

//ArrayList：底层由数组结构实现 Object[]，可以存储任何 Object 类型的对象，是非线程安全的

//LinkedList：List和 Deque 接口的双向链表实现。实现所有可选列表操作，并允许所有元素（包括 null ）。
//所有操作都按照双向链表的预期执行。索引到列表中的操作将从开头或结尾遍历列表，以更接近指定索引的为准。

//Vector：底层实现是动态数组的方式存放数据，是线程安全的，Vector源码当中每个方法都被synchronized关键字进行修饰，
// 保证了Vector的线程安全，所以效率很低，尽量少使用

public class list
{
    public static void main(String[] args)
    {
        List list1 = new ArrayList<Integer>();
        list1.add(4);
        list1.add(5);
        list1.add(6);
        LinkedList<Object> list2 = new LinkedList<>();
        LinkedList<Object> list3 = new LinkedList<>();
        list3.add(1);
        list3.add(2);
        list3.add(3);
        list3.addAll(3,list1);


    }
}
