package student.learn_java;
import java.lang.*;

// StringBuilder 的使用 -- StringBuilder 类相比于 StringBuffer 类的不同之处在于：StringBuilder 类的线程是不安全的，
// 而 StringBuffer 的线程是安全的，但是 StringBuffer 的运行速度比 StringBuilder 慢
public class StringBuilderTest
{
    public static void main(String[] args)
    {
        System.out.println("----append()----");
        StringBuilder sb1 = new StringBuilder("大学");    // 可添加任意类型
        sb1.append("第");
        sb1.append(0);  // 0 自动转为为 String 类型
        char aa[] = {'1','2','3','4','5','6'};
        sb1.append(aa);     // 添加字符数组
        System.out.println(sb1);
        System.out.println("-----setCharAt()-----");
        sb1.setCharAt(0, '学');
        sb1.setCharAt(1, '院');
        System.out.println(sb1);
        System.out.println("-----insert()-----");
        sb1.insert(0, "海滨");
        System.out.println(sb1);
        System.out.println("-----delete()-----");
        sb1.delete(5,10);
        System.out.println(sb1);
        System.out.println("-----deleteCharAt()-----");
        sb1.deleteCharAt(5);
        System.out.println(sb1);
        System.out.println("-----replace()-----");
        sb1.replace(0,4,"");
        System.out.println(sb1);
    }
}
