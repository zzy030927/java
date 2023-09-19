package student.learn_java;
import java.util.regex.Pattern; // 匹配的模式
import java.util.regex.Matcher; // 匹配的结果


// 正则表达式
// . 表示任意字符
// * 表示 0 - 多个字符
// + 表示 1 - 多个字符
// ? 表示 0 或者 1个字符
// {a,b} 表示长度在 a 到 b之间,默认 a 为 0
// [a-b] 表示数字值在 a 到 b 之间
// [] 代表 匹配括号内任意一个字符，   例： [abc] 匹配 a\b\c 任意一个
// [^] 代表 除了括号内的字符都可以被匹配，这是一个取反操作
// \r 回车
// \\s 表示所有空白字符
// \\S 表示所有非空白字符， \\S 表示一个字符，除了空白
// \\w 匹配一个任意大小写的字符，_，数字
// \\W 与 \\w 相反
// ^h 以 h字符开头
// h$ 以 h字符结尾
// \\b 分隔符
// [.-] 以 . 连接，例如： [\\w[.-]]* 任意多个字符之间用 . 连接,例如： cg.av.dage.wer

public class RegularExpression
{
    public static void main(String[] args)
    {
        // matches() 函数，    regex 正则表达式，如果字符串与正则表达式匹配，那么返回 true
        System.out.println("123".matches("12."));
        // replaceAll(regex, replacement); 第一个参数为 正则表达式 \d 为 0-9的数字， 加一个 \ 使 \ 不再是一个转义字符
        System.out.println("a21343132abc".replaceAll("\\d", "-"));
        String regex = "2";
        System.out.println("a21343132abc".replaceAll(regex, "-"));
        System.out.println("-------取反操作--------");
        System.out.println("3134".matches("[^2]*"));
        System.out.println("-------匹配所有非空白字符--------");
        System.out.println(" ".matches("\\S"));
        System.out.println("1234".matches("\\S.*"));
        System.out.println("-------\\w--------");
        System.out.println("a_8".matches("\\w_\\d"));
        System.out.println("-----Pattern与Matcher的使用----");
        Pattern pa = Pattern.compile("\\d*");   // Pattern 类用于创建一个正则表达式
        Matcher ma = pa.matcher("123567");      // 用创建的正则表达式 预匹配 传入的字符串,这一步还不进行匹配，返回一个匹配器类 Matcher
        System.out.println(ma.matches());             // Matcher 类中有一个方法 matchers() 用于匹配创建的正则表达式与 传入的字符串是否相等
        String test1 = "Java1234";
        String test2 = "1234Java";
        Pattern pattern = Pattern.compile("Java");
        Matcher matcher = pattern.matcher(test1);
        System.out.println("-----Matcher类中lookingAt()与find()------");
        System.out.println(matcher.lookingAt());    // lookingAt()从字符串开始匹配与正则表达式相同的字串，如果有，返回 true
        Matcher matcher1 = pattern.matcher(test2);
        System.out.println(matcher1.lookingAt());   // 开始匹配失败，返回 false
        System.out.println(matcher1.find());        // 从任意位置开始匹配字符串字串
        System.out.println(matcher1.find(5));  // 从 start 开始位置开始匹配字符串字串下·
        System.out.println("-------Matcher类中start()、end()、group()-------");
        matcher1.find();    // 使用 start() 函数前要先 find 寻找字串一次
        System.out.println(matcher1.start());   // 如果匹配成功，返回 匹配成功的开始位置，如果匹配失败，那么报错
        System.out.println(matcher1.end());     // 返回匹配成功的结束位置
        System.out.println("-------Matcher类中region()------");
        matcher1.region(0,6);   // 锁定匹配的范围
        System.out.println(matcher1.regionStart()); // 返回锁定范围的开始位置
        System.out.println(matcher1.regionEnd());   // 返回锁定范围的结束位置
        System.out.println(matcher1.find());
        System.out.println("--------Matcher类中的replaceAll()和replaceFirst()--------");
        String test3 = "Java123456Java";
        Matcher matcher2 = pattern.matcher(test3);
        System.out.println(matcher2.replaceAll("Python"));  // 替换全部匹配上的字符字串
        System.out.println(matcher2.replaceFirst("C++"));   // 替换第一个匹配上的字符字串
        System.out.println("------Matcher类中的appendReplacement()和appendTail()-------");
        Pattern pattern3 = Pattern.compile("Java");
        Matcher matcher3 = pattern3.matcher("Java1234");
        System.out.println(matcher3.find());//返回true
        StringBuffer sb = new StringBuffer();
        matcher3.appendReplacement(sb, "Python");   // 将匹配到的字符子串添加到 sb 实例中
        System.out.println(sb);//输出Python
        matcher3.appendTail(sb);                                // 将 未匹配到的 字符子串添加到 sb 实例中
        System.out.println(sb);//输出Python1234
    }
}
