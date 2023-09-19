package CollectionDemo;

import java.util.*;
import java.util.Set;

class Student2{
    private String s_id;
    private String s_name;

    public Student2(String s_id, String s_name) {
        this.s_id = s_id;
        this.s_name = s_name;
    }

    public String getS_id() {
        return s_id;
    }

    public String getS_name() {
        return s_name;
    }
}

public class MapTest {
    public static void main(String[] args) {
        // HashMap<k,v> ������ʵ���˷��ͽӿ� Map<k,v> ������ Hash ��ʽ�洢���ݣ����洢����ʱ����������ͬʱ���ú���һ�����滻ǰ��ļ���ֵ��
        // HashMap�Ĵ洢�����ǲ��̶��ģ���Ϊ��ϣ������ ������ �������
        // HashMap������ null key �� null value
        HashMap<String, String> hashMap = new HashMap<String, String>();
        hashMap.put("001","java");
        hashMap.put("002","go");
        hashMap.put("003","c++");
        hashMap.put("004","c#");
        hashMap.put("005","python");
        Set<String> keySet = hashMap.keySet();  // ������
        System.out.println("---------������--------");
        for (String key : keySet) {
            System.out.println(key);
        }
        System.out.println("---------ֵ����-------");
        Collection<String> values = hashMap.values();
        for (String value : values) {
            System.out.println(value);
        }
        System.out.println("-----HashMap��TreeMap����ʹ�ã�ʹ�õ�Student2�ࣩ----");
        // TreeMap ������Ԫ�ض������Ź̶���˳��,�����ݼ��Ĵ�С����
        System.out.println("---------------HashMap ʹ��-----------");
        HashMap<String, String> hashMap1 = new HashMap<>();
        Student2 stu1 = new Student2("001", "С��");
        Student2 stu2 = new Student2("011", "С��");
        Student2 stu3 = new Student2("021", "С��");
        Student2 stu4 = new Student2("023", "С��");
        hashMap1.put(stu1.getS_id(), stu1.getS_name());
        hashMap1.put(stu2.getS_id(), stu2.getS_name());
        hashMap1.put(stu3.getS_id(), stu3.getS_name());
        hashMap1.put(stu4.getS_id(), stu4.getS_name());
        Set<String> keySet1 = hashMap1.keySet();  // ������
        System.out.println("---------������--------");
        for (String key : keySet1) {
            System.out.println(key);
        }
        System.out.println("---------ֵ����-------");
        Collection<String> values1 = hashMap1.values();
        for (String value : values1) {
            System.out.println(value);
        }
        System.out.println("---------------TreeMap ʹ��-----------");
        TreeMap<String, String> treeMap = new TreeMap<>();
        treeMap.putAll(hashMap1);
        Iterator<String> iterator = treeMap.keySet().iterator();
        while(iterator.hasNext()){
            String key = iterator.next();
            String value = treeMap.get(key);
            System.out.println(key + " " + value);
        }
    }
}
