package student.learn_java;
import java.lang.*;
import java.util.ArrayList;

//��̬����
public class dynamic_arry
{
    public static void main(String[] args)
    {
        ArrayList<String> arr = new ArrayList<String>();    // ���Ͳ�������Ϊ int\double�����ͣ��� ��Ԫ ����
        arr.add("abcde");   //���ַ�����ӵ� ArrayList ��
        System.out.println(arr);

        ArrayList<String> arr1 = new ArrayList<String>();
        arr1.add("fjhigk");
        arr.addAll(arr1);   // �ַ��� arr ������� arr1
        System.out.println(arr);

        ArrayList<String> arr2 = new ArrayList<String>();
        arr2.add("������");
        arr.addAll(1, arr2);    // �� arr2 ȫ��������ӵ� arr �� 1 ��Ԫ�غ�ע�⣺�ǵ�һ��Ԫ�أ���һ��Ԫ�ص������� 0
        System.out.println(arr);

        arr.remove(1);         // ɾ�� arr ����Ϊ 1 ������
        System.out.println(arr);

        arr.set(1,"zhang");         // �޸����ݣ�����Ϊ 1
        System.out.println(arr);

        String elem;
        elem = arr.get(1);       // ��ȡ����Ϊ 1 ������
        System.out.println(elem);

        arr.remove("fjhigk");   // ɾ��ָ��Ԫ��
        // arr.remove(arr1);
        System.out.println(arr);

        arr.clear();    // �������
        System.out.println(arr);
    }

}
