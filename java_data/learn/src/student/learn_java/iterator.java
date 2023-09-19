package student.learn_java;
import java.util.*;

// Iterator 迭代器，它是一个接口，是可以遍历集合的对象，为各种容器提供了公共的接口，隔离对容器的遍历操作和底层实现。
// 此接口只有一个方法，iterator() ： 获取一个迭代器

// 而迭代器的作用为： 遍历/迭代集合(数组)元素
// 有三个方法: hashNext() ：询问有没有下一个元素
// next() : 移动到下一个元素,并返回该位置上的元素
// remove() : 从迭代器指向的 collection 中移除迭代器返回的最后一个对象 (可选操作)。
public class iterator
{
    public static void main(String[] args)
    {
        // Integer 是一个基类的包，里面包含了 int\double\float 等类型，但是没有 String。
        ArrayList<Integer>  arr = new ArrayList<>();
        arr.add(10);
        arr.add(20);
        arr.add(30);
        arr.add(40);
        System.out.println(arr);    // arr 为一个集合
        Iterator<Integer> iter= arr.iterator();     // iter 为一个迭代器
        while(iter.hasNext())   // 询问有没有下一个元素
        {
            System.out.print(iter.next() + " ");    // 移动到下一个元素，并返回这个元素
            iter.remove();  // 删除当前元素
        }
        System.out.print("\n" + arr);
    }
}
