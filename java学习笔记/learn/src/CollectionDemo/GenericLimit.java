package CollectionDemo;
import java.util.ArrayList;
import java.util.List;
// ͨ�������


/*
    1. ��ʵ���������ʱ�򣬲�ȷ�����Ͳ����ľ�������ʱ������ʹ��ͨ������ж�����
    2. <? extends Object>�����ϱ߽��޶�ͨ���
    3. <? super Object>�����±߽��޶�ͨ�����

    ͨ������� add() �����յ����ƣ����ǿ���������ȡ�����������͵����ݣ�����ֵ�������͵����á�
    List<? extends Number> list=null;
    list=new ArrayList<Integer>();
    list.add(new Integer(1)); // ������Ϊ list����ȷ��ʵ�����Ķ���������͵��� add()��������,
                                 ��Ϊ add �����ײ�ʹ�õ����� Object[] ������������ݣ�
                                 ������Ҫȷ��Ԫ�صľ������ͣ��Ա��ڱ���ʱ������͵���ȷ�ԣ�
                                 ����ʹ��ͨ������޺�Ԫ�ص������ǲ�ȷ���ģ����Ա������޷�ȷ����ӵ�Ԫ���Ƿ���Ϸ����������涨�����ޡ�
    ...
    list.get(0);//��ȷ
 */

// ͨ��������÷�
class GenericUpLimit {
    public static void main(String[] args) {
        firstPrint();
        secondPrint();
    }

    public static void firstPrint() {
        List<Float> list1 = new ArrayList<>();//ʹ�� Float��ʵ������
        list1.add(12.3f);
        list1.add(23.4f);
        print(list1);
    }

    public static void secondPrint() {
        List<Integer> list2 = new ArrayList<>();//ʹ��Integer��ʵ������
        list2.add(1);
        list2.add(2);
        list2.add(3);
        print(list2);
    }

    public static void print(List<? extends Number> list) {// ͨ������β�
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));// ʹ��get����
        }
    }
}

// ͨ��������÷�
/*
    ͨ������ޣ��洢����ʱ��������ֻ���ǵ�ǰ�࣬���ǵ�ǰ�������, ȡ����ʱֻ��ʹ�� Object ���ͽ�������
    ���ø���������ݵ�ԭ�򣺵�����ʹ��ͨ������޻�ȡ�б��е�Ԫ��ʱ��
                        ��Ȼ����֪��Ԫ�ص������� Integer���丸�࣬������ Java�����е����Ͳ������ƣ�
                        �������޷�ȷ���������ͣ�������Ԫ�ص����ͻᱻ����Ϊ Object���ͣ�
                        ������ֻ����������ʱ�����ͼ����ȷ�����Ͱ�ȫ��
    List<? super Integer> list = null;
    list = new ArrayList<Number>();
    list.add(1);
    Number number = list.get(0);
    ...
    list.add(1);//��ȷ�� ��Ϊ ��������ӵĲ��� �Լ������ͣ����Ǹ�������͡�
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

    public static void firstInflate(List<? super Integer> list) {// װ������
        list.add(1);
        list.add(2);
        list.add(3);
    }

    public static void secondInflate(List<? super Float> list) {// װ�����
        list.add(1.1f);
        list.add(2.2f);
        list.add(1.3f);
    }
}


public class GenericLimit {
    public static void main(String[] args) {
    }
}
