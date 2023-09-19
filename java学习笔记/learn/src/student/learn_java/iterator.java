package student.learn_java;
import java.util.*;

// Iterator ������������һ���ӿڣ��ǿ��Ա������ϵĶ���Ϊ���������ṩ�˹����Ľӿڣ�����������ı��������͵ײ�ʵ�֡�
// �˽ӿ�ֻ��һ��������iterator() �� ��ȡһ��������

// ��������������Ϊ�� ����/��������(����)Ԫ��
// ����������: hashNext() ��ѯ����û����һ��Ԫ��
// next() : �ƶ�����һ��Ԫ��,�����ظ�λ���ϵ�Ԫ��
// remove() : �ӵ�����ָ��� collection ���Ƴ����������ص����һ������ (��ѡ����)��
public class iterator
{
    public static void main(String[] args)
    {
        // Integer ��һ������İ������������ int\double\float �����ͣ�����û�� String��
        ArrayList<Integer>  arr = new ArrayList<>();
        arr.add(10);
        arr.add(20);
        arr.add(30);
        arr.add(40);
        System.out.println(arr);    // arr Ϊһ������
        Iterator<Integer> iter= arr.iterator();     // iter Ϊһ��������
        while(iter.hasNext())   // ѯ����û����һ��Ԫ��
        {
            System.out.print(iter.next() + " ");    // �ƶ�����һ��Ԫ�أ����������Ԫ��
            iter.remove();  // ɾ����ǰԪ��
        }
        System.out.print("\n" + arr);
    }
}
