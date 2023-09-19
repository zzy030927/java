package CollectionDemo;

import java.util.ArrayList;
import java.util.List;

// ����
class _Generic
{
    //     <T> ָ���÷���ʹ�õ����� T
    //     ����ֵΪ���� T
    //     show(T t)   ���ݷ��� T
    public <T> T show(T t)
    {
        return t;
    }
}

class e<T>  // Ĭ�� T Ϊ Object ����
{

}
//���� �̳� ���͸�����������
// 1.����Ҳ�Ƿ���
class f<T> extends e
{

}
// 2.���಻�Ƿ��� ����������� ����Ĳ�����ʲô
class g extends e<String>
{

}

// ���ͽӿ�, <T> ָ���ýӿ�Ϊ���ͽӿ�
interface genericInterface<T>
{
    // <T1> ˵�� show1 Ϊ���ͷ��������˵���������Ϊ���ͷ���,
    // ע�� t ʹ�õ��� ���ͷ�����������ͣ� t2ʹ�õ��Ƿ��ͽӿڴ��������,���������ǲ�ͬ��
    <T1>T1 show1(T1 t, T t2);
    void show2();
    T show3(T t);
}

// �̳� genericInterface�ӿ�
// ˵������������ ���ͷ����� Impl<T>
// genericInterface<T> �̳��� �ӿ� genericInterface
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
        // ctrl + alt + v �Զ�����һ����Ӧ������
        _Generic generic = new _Generic();
        String str = generic.show("str");
        System.out.println(generic.show("str"));
        System.out.println(generic.show(true));
        System.out.println(generic.show(213));
        System.out.println(generic.show("--------���ͽӿ�---------"));
        Impl<Integer> objectImpl = new Impl<>();
        String str1 = objectImpl.show1("str1", 123);
        System.out.println(str1);
        System.out.println("--------ͨ���---------");
        ArrayList<String> strings = new ArrayList<>();
        ArrayList<Integer> integers = new ArrayList<>();
        printList(strings);
        printList(integers);
        ArrayList<?> objects = new ArrayList<>();
        // ���Խ������еķ�������
        // objects.add(); ���������������
        System.out.println("---------���Ͳ�������--------");
        // ����ԭ���ײ�ʹ���� ��������
        // �������ڱ���׶����ƴ��ݵ�����
        // ˵���� ��һ�� List ���Ϸ��� ��ֵ��һ��û��ʹ�õ����� List ���ϣ�ֱ��ȥ������ ----- ��������
        List<String> str3 = new ArrayList<>();
        str3.add("123");
        // str3 ֻ����� String ���ͣ���Ϊ ���͹涨��ֻ�ܴ��� String ����
        List list = str3;
        // list �ܴ����κ����͵Ĳ�������Ϊ �������ƣ�ȥ�����ͣ����� list ������κ�����
        list.add("1");
        list.add("2345");
    }
    // ? Ϊͨ��������Խ������еķ�������
    // List<?> ֻ�����ڽ������ݣ����ǲ��ܹ������������
    public static void printList(List<?> list)
    {
        // list.add();
        // ����
    }
    // (List<? extends Impl> list��ͨ��� ? extends Impl ʹ�� list ֻ�ܴ��� Impl ����������࣬ �����ͨ��� ��Ϊ ͨ�������
    public void printList(List<? extends Impl> list, int a)
    {

    }

    // ����� List<? super d>list ��Ϊ ͨ������ޣ�ֻ�ܽ��� �� d �� ���ĸ���
    public void printList1(List<? super d> list)
    {

    }

}