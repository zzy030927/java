package student.learn_java;
import java.lang.*;
import java.util.ArrayList;

//动态数组
public class dynamic_arry
{
    public static void main(String[] args)
    {
        ArrayList<String> arr = new ArrayList<String>();    // 类型参数不能为 int\double等类型，即 基元 类型
        arr.add("abcde");   //将字符串添加到 ArrayList 中
        System.out.println(arr);

        ArrayList<String> arr1 = new ArrayList<String>();
        arr1.add("fjhigk");
        arr.addAll(arr1);   // 字符串 arr 添加整个 arr1
        System.out.println(arr);

        ArrayList<String> arr2 = new ArrayList<String>();
        arr2.add("哈哈哈");
        arr.addAll(1, arr2);    // 将 arr2 全部数据添加到 arr 第 1 个元素后，注意：是第一个元素，第一个元素的索引是 0
        System.out.println(arr);

        arr.remove(1);         // 删除 arr 索引为 1 的数据
        System.out.println(arr);

        arr.set(1,"zhang");         // 修改数据，索引为 1
        System.out.println(arr);

        String elem;
        elem = arr.get(1);       // 获取索引为 1 的数据
        System.out.println(elem);

        arr.remove("fjhigk");   // 删除指定元素
        // arr.remove(arr1);
        System.out.println(arr);

        arr.clear();    // 清空数据
        System.out.println(arr);
    }

}
