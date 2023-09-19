package CollectionDemo;

import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;

// HashSet : ���򡢲��ظ���������
// LinkedSet : ���򡢲��ظ���������
// TreeSet : �����򡢲��ظ���������
class student1 implements Comparable{
    int english = 0;
    String name;
    public student1(int english, String name) {
        this.english = english;
        this.name = name;
    }

    // ��Ϊ�洢 student ����ʱ��ϵͳ��֪��Ҫ�� english ������������ name ��������
    // ����ʵ�� Comparable �ӿڣ�ʵ������ıȽϷ�������������ڴ�������ʱ�Զ������á�
    @Override
    public int compareTo(Object b) {
        student1 student = (student1)b;
        if(this.english - student.english == 0)
            return 1;
        return this.english - student.english;
    }
}

public class Set    // �� Set �У�ͬһ������ֻ��һ��
{
    public static void main(String[] args) {
        System.out.println("-----����-----");
        HashSet<Object> set1 = new HashSet<>(); // �� ��ϣ�б� �洢
        int a = 1;
        set1.add(a);
        set1.add(a);
        String s = new String("123");
        String s1 = s;
        set1.add(s);
        set1.add(s1);   // ͬ��ֻ��һ��
        for (Object p : set1) {
            System.out.println(p);
        }
        System.out.println("-----------");
        TreeSet<Object> set2 = new TreeSet<>(); // �� ���洢
        // TreeSet �ǰ��� ���������д洢�� ���ݴ����������α�󣬴����������α�������� ��α�����
        set2.add(3);
        set2.add(5);
        set2.add(8);
        set2.add(6);
        set2.add(2);
        set2.add(1);
        for (Object treeSet : set2) // ������ʽ���ղ�α���
        {
            System.out.println(treeSet);
        }
        System.out.println("--------Ӧ�ã�ʹ�õ�student1�ࣩ----------");
        TreeSet<student1> tree = new TreeSet<>();
        student1 stu1, stu2, stu3, stu4;
        stu1 = new student1(90, "����");
        stu2 = new student1(66, "����");
        stu3 = new student1(86, "����");
        stu4 = new student1(86, "����");
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


