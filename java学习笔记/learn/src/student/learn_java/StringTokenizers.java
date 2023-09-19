package student.learn_java;
import java.util.*;

// StringTokenizer 类的作用：生成一个分析器，将一个字符串拆分为多个单词。
public class StringTokenizers
{
    public static void main(String[] args)
    {
        String str = "we are student";
        StringTokenizer st = new StringTokenizer(str);  // 默认 空格 为分割字符串的标记
        // StringTokenizer stringTokenizer = new StringTokenizer(str, ",");     改变为 , 为分割字符串的标记
        int number = st.countTokens();  // 获取分割的单词数量
        while(st.hasMoreElements())     // 判断还有没有下一个单词
        {
            String word = st.nextToken();   // 返回当前的单词，并跳转到下一个单词
            System.out.println(word);
            System.out.println("还剩" + st.countTokens() + "个单词");
        }
    }
}
