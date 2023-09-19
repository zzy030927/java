package CollectionDemo;

import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;

// HashSet : 无序、不重复、无索引
// LinkedSet : 有序、不重复、无索引
// TreeSet : 可排序、不重复、无索引
class student1 implements Comparable{
    int english = 0;
    String name;
    public student1(int english, String name) {
        this.english = english;
        this.name = name;
    }

    // 因为存储 student 数据时，系统不知道要用 english 进行排序还是用 name 继续排序，
    // 所以实现 Comparable 接口，实现里面的比较方法，这个方法在创建数据时自动被调用。
    @Override
    public int compareTo(Object b) {
        student1 student = (student1)b;
        if(this.english - student.english == 0)
            return 1;
        return this.english - student.english;
    }
}

public class Set    // 在 Set 中，同一个对象只放一次
{
    public static void main(String[] args) {
        System.out.println("-----概述-----");
        HashSet<Object> set1 = new HashSet<>(); // 用 哈希列表 存储
        int a = 1;
        set1.add(a);
        set1.add(a);
        String s = new String("123");
        String s1 = s;
        set1.add(s);
        set1.add(s1);   // 同样只放一次
        for (Object p : set1) {
            System.out.println(p);
        }
        System.out.println("-----------");
        TreeSet<Object> set2 = new TreeSet<>(); // 用 树存储
        // TreeSet 是按照 二叉树进行存储， 数据从上往下依次变大，从左往右依次变大，类似于 层次遍历。
        set2.add(3);
        set2.add(5);
        set2.add(8);
        set2.add(6);
        set2.add(2);
        set2.add(1);
        for (Object treeSet : set2) // 遍历方式按照层次遍历
        {
            System.out.println(treeSet);
        }
        System.out.println("--------应用（使用到student1类）----------");
        TreeSet<student1> tree = new TreeSet<>();
        student1 stu1, stu2, stu3, stu4;
        stu1 = new student1(90, "张三");
        stu2 = new student1(66, "李四");
        stu3 = new student1(86, "王五");
        stu4 = new student1(86, "赵六");
        tree.add(stu1);
        tree.add(stu2);
        tree.add(stu3);
        tree.add(stu4);
        Iterator<student1> iterator = tree.iterator();
        while (iterator.hasNext()) {
            student1 stu = iterator.next();
            System.out.println(stu.name + " source: " + stu.english);
        }
    }
}


