package CollectionDemo;

import java.util.*;

// ���� List
// ���ϣ� �Ѿ�����ͬԪ�صĶ�������һ��Ҳ������������
// List: �� java.util �µ�һ���ӿڣ����򼯺ϣ�Ҳ���Գ�Ϊ���У����û����Ծ�׼����ÿ��Ԫ�����б�Ĳ���λ�ã�
// �û�����ͨ����������Ԫ�أ������б�������Ԫ�ء�

// List ��̳��� Collection �ӿڲ��� AbstractList ��ʵ�֣�Collection �ּ̳��� Iterable �ӿ�

// List �� ���ࣺList������

//ArrayList���ײ�������ṹʵ�� Object[]�����Դ洢�κ� Object ���͵Ķ����Ƿ��̰߳�ȫ��

//LinkedList��List�� Deque �ӿڵ�˫������ʵ�֡�ʵ�����п�ѡ�б����������������Ԫ�أ����� null ����
//���в���������˫�������Ԥ��ִ�С��������б��еĲ������ӿ�ͷ���β�����б��Ը��ӽ�ָ��������Ϊ׼��

//Vector���ײ�ʵ���Ƕ�̬����ķ�ʽ������ݣ����̰߳�ȫ�ģ�VectorԴ�뵱��ÿ����������synchronized�ؼ��ֽ������Σ�
// ��֤��Vector���̰߳�ȫ������Ч�ʺܵͣ�������ʹ��

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
