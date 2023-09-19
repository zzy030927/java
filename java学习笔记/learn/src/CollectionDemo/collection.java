package CollectionDemo;

import java.util.*;

// ��ļ̳� Collection �� Map Ϊ����
// Collection -> List -> ArrayList && LinkedList
// Collection -> Set -> HashSet && TreeSet
// Map -> HashMap && TreeMap

// ��Щ�������ֳ�Ϊ�����������鲻ͬ������ĳ����ǹ̶��ģ����ϵĳ����ǿɱ�ģ�����������Ż����������ͣ�����������������
// Collection�ǲ�νṹ�еĸ��ӿڣ���ŵĶ����ֳ�ΪԪ�ء��ýӿ��� List�� Set�ӿڵĸ��ӿڣ�һ�㲻ֱ��ʹ�á�
// �� Collection�ӿ��ж�����һЩͨ�õķ�������Щ������ List�ӿں� Set�ӿ���ͨ�õġ�
// Collection��Ϊ������ĸ��ӿڣ�ͨ���ڳ�������в�ֱ��ʹ�øýӿڣ�
// ����ʹ��List�ӿڣ�Set�ӿ��� Map�ӿڡ�List�����еĶ�������ظ����壬������˳�����У�
// Set�����еĶ���û���ظ���������˳�����У�Map���ϰ��� Key��Value��ʽ�洢��
public class collection
{
    public static void main(String[] args)
    {
        System.out.println("-----Collection�� ArrayListʵ��-----");
        Collection collection = new ArrayList();
        collection.add("apple");        // add ���Ԫ��
        collection.add("orange");
        collection.add("pear");
        Iterator it = collection.iterator();
        while(it.hasNext())
        {
            System.out.print(it.next() + " ");
        }
        System.out.println("\n--addAll����--");
        Collection col2 = new ArrayList();
        col2.addAll(collection);    // addAll()���� ���ڽ�ָ�������е����ж�����ӵ������С�
        Iterator it2 = col2.iterator();
        while(it2.hasNext())
        {
            System.out.print(it2.next() + " ");
        }
        col2.add("peach");
        col2.add("watermelon");
        System.out.println("\n--removeAll����--");
        col2.removeAll(collection); // �� col2 �����а��� collection ���ϵ�����Ԫ���Ƴ���
        Iterator it3 = col2.iterator();
        while(it3.hasNext())
        {
            System.out.print(it3.next() + " ");
        }
        System.out.println("\n-----List���� ArrayListʵ��-----");
        // List���ϰ��� List�ӿں� List�ӿڵ�����ʵ���ࡣList�ӿڼ̳� Collection�ӿڣ���˾��иýӿ��е����з�����
        // List����Ϊ�б����ͣ������Է�ʽ�洢����

        // ArrayList ʵ���� List �ӿڣ���������ṹ�������
        // ��ȱ�㣺�ŵ��ǣ����ڶԼ����е�Ԫ�ؿ��ٷ��ʣ����������Ҫ��������λ�÷���Ԫ�أ�
        // ʹ�� ArrayList��ʵ�ֵ� List���ϵ�Ч�ʽϸߡ�ȱ���ǣ������ɾ��Ԫ��ʱ��Ч�ʽϵͣ�ԭ���ǣ����к���Ԫ�ض�������λ����������Ǿ޴�ġ�
        String a = "A", b = "B", c = "C";
        List<String> list = new ArrayList<String>();
        list.add(a);

    }
}
