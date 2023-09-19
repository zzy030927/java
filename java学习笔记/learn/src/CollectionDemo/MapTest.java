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
        // HashMap<k,v> 泛型类实现了泛型接口 Map<k,v> ，采用 Hash 方式存储数据，当存储数据时有两个键相同时，用后面一个键替换前面的键的值。
        // HashMap的存储序列是不固定的，因为哈希排序中 被除数 是随机的
        // HashMap允许多个 null key 和 null value
        HashMap<String, String> hashMap = new HashMap<String, String>();
        hashMap.put("001","java");
        hashMap.put("002","go");
        hashMap.put("003","c++");
        hashMap.put("004","c#");
        hashMap.put("005","python");
        Set<String> keySet = hashMap.keySet();  // 键集合
        System.out.println("---------键集合--------");
        for (String key : keySet) {
            System.out.println(key);
        }
        System.out.println("---------值集合-------");
        Collection<String> values = hashMap.values();
        for (String value : values) {
            System.out.println(value);
        }
        System.out.println("-----HashMap和TreeMap具体使用（使用到Student2类）----");
        // TreeMap 中所有元素都保持着固定的顺序,（根据键的大小排序）
        System.out.println("---------------HashMap 使用-----------");
        HashMap<String, String> hashMap1 = new HashMap<>();
        Student2 stu1 = new Student2("001", "小葛");
        Student2 stu2 = new Student2("011", "小陈");
        Student2 stu3 = new Student2("021", "小赵");
        Student2 stu4 = new Student2("023", "小刘");
        hashMap1.put(stu1.getS_id(), stu1.getS_name());
        hashMap1.put(stu2.getS_id(), stu2.getS_name());
        hashMap1.put(stu3.getS_id(), stu3.getS_name());
        hashMap1.put(stu4.getS_id(), stu4.getS_name());
        Set<String> keySet1 = hashMap1.keySet();  // 键集合
        System.out.println("---------键集合--------");
        for (String key : keySet1) {
            System.out.println(key);
        }
        System.out.println("---------值集合-------");
        Collection<String> values1 = hashMap1.values();
        for (String value : values1) {
            System.out.println(value);
        }
        System.out.println("---------------TreeMap 使用-----------");
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
