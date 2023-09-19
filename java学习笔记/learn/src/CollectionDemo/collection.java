package CollectionDemo;

import java.util.*;

// 类的继承 Collection 与 Map 为父类
// Collection -> List -> ArrayList && LinkedList
// Collection -> Set -> HashSet && TreeSet
// Map -> HashMap && TreeMap

// 这些集合类又称为容器，与数组不同，数组的长度是固定的，集合的长度是可变的，数组用来存放基本数据类型，集合用来存放类对象。
// Collection是层次结构中的根接口，存放的对象又称为元素。该接口是 List和 Set接口的父接口，一般不直接使用。
// 在 Collection接口中定义了一些通用的方法，这些方法对 List接口和 Set接口是通用的。
// Collection作为集合类的父接口，通常在程序设计中不直接使用该接口，
// 而是使用List接口，Set接口与 Map接口。List集合中的对象可以重复定义，按插入顺序排列；
// Set集合中的对象没有重复，但不按顺序排列；Map集合按照 Key—Value形式存储。
public class collection
{
    public static void main(String[] args)
    {
        System.out.println("-----Collection类 ArrayList实现-----");
        Collection collection = new ArrayList();
        collection.add("apple");        // add 存放元素
        collection.add("orange");
        collection.add("pear");
        Iterator it = collection.iterator();
        while(it.hasNext())
        {
            System.out.print(it.next() + " ");
        }
        System.out.println("\n--addAll方法--");
        Collection col2 = new ArrayList();
        col2.addAll(collection);    // addAll()方法 用于将指定集合中的所有对象都添加到集合中。
        Iterator it2 = col2.iterator();
        while(it2.hasNext())
        {
            System.out.print(it2.next() + " ");
        }
        col2.add("peach");
        col2.add("watermelon");
        System.out.println("\n--removeAll方法--");
        col2.removeAll(collection); // 将 col2 集合中包含 collection 集合的所有元素移除。
        Iterator it3 = col2.iterator();
        while(it3.hasNext())
        {
            System.out.print(it3.next() + " ");
        }
        System.out.println("\n-----List集合 ArrayList实现-----");
        // List集合包含 List接口和 List接口的所有实现类。List接口继承 Collection接口，因此具有该接口中的所有方法。
        // List集合为列表类型，以线性方式存储对象。

        // ArrayList 实现了 List 接口，采用数组结构保存对象。
        // 优缺点：优点是：便于对集合中的元素快速访问，如果经常需要根据索引位置访问元素，
        // 使用 ArrayList类实现的 List集合的效率较高。缺点是：插入和删除元素时的效率较低，原因是，所有后续元素都必须移位，这个操作是巨大的。
        String a = "A", b = "B", c = "C";
        List<String> list = new ArrayList<String>();
        list.add(a);

    }
}
