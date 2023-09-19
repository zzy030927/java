package student.learn_java;

public class string
{
    public static void main(String[] args)
    {
        // s1 指向常量字符串 "ABCd-AFG,CA"的地址
        String s1="ABCd-AFG,CA";
        String s2="AccD-";
        // 用String 类构建对象
        String s3 = new String(s1);
        System.out.println("String 类创建对象: " + s3);
        char ch[] = {'a','b','c','d'};
        String s4 = new String(ch,1,2); //从 ch 数组的 offset 开始，长度为 count 构造 String对象
        System.out.println("用char类型数组创建String类对象: " +s4);
        System.out.println("-------equals()与 == 的区别--------");
        // equal() 比较的是两个字符串的值是否相等
        // 而 == 比较的是两个字符串的地址是否相等
        String eq = new String("123");
        String eq1 = new String("123");
        System.out.println(eq == eq1);  // false, 因为 这里 使 new 出两个 值为 123 的对象，它们俩的地址是不一样的
        System.out.println(eq.equals(eq1)); // true  equals()比较的是两个实例的值是否相等
        String e1 = "123";
        String e2 = "123";
        System.out.println(e1 == e2);   // true，这里将 常量 123 的地址赋值给 e1 和 e2 ，所以 e1 == e2 为 true
        System.out.println("-------equalsIgnoreCase--------");
        System.out.println(s1.equalsIgnoreCase(s2));    // 判断两个字符串是否相等，不分大小写
        System.out.println("-------StatrsWith--------");
        System.out.println(s1.startsWith("AB"));        // 判断是否以该字符串开始
        System.out.println(s1.endsWith("CD"));          // 判断是否以该字符串结尾

        boolean c = false;
        System.out.println("-------regionMatches--------");
        c = s1.regionMatches(true, 1, s2, 1, 3);
        // regionMatches(boolean b, int firstStart, String other, int otherStart, int length)
        // 从当前字符串的firstStart开始，取长度为length的一个字符串，
        // other从otherStart位置也取一个长度为length的字符串，两字符串进行比较。
        // 当b为true时，两字符串不区分大小写。
        System.out.println(c);
        System.out.println("-------compare--------");
        System.out.println(s1.compareTo(s2));
        // compareTo 比较函数，创建一个字典比较两个字符串，返回 s1 与 s2 之间第一个不同字符之间的差值
        System.out.println("-------contain--------");
        System.out.println(s2.contains("AD"));  // 检查字符串中是否包含 ac
        System.out.println("-------indexOf--------");
        System.out.println(s1.indexOf("AB"));   // 检查 "AB" 在 s1 字符串中第一次出现的位置，没有返回 -1
        System.out.println(s1.indexOf("C",2));
        //从索引为 2 的位置开始搜索 字符 C,返回它首次出现的位置。

        System.out.println(s1.lastIndexOf("c",2));
        // 从字符串开头开始搜索，到 fromIndex 的位置结束，查找 字符串 "c" 第一次出现的位置，
        // fromIndex 参数默认为字符串的长度

        String s5;
        s5 = s1.substring(1,3);   // 从索引位置为 1 的位置开始截取字符串赋值给 s5,到 索引位置 3结束
                                    // 结束位置默认为 字符串的长度
        System.out.println(s5);
        System.out.println("-------分割字符串--------");
        String []into;
        into = s1.split("-|,");     // '|' 是或者
        // 用字符串 '-' 或者 ',' 分割字符串 s1, 把这个字符串数组赋值给 into
        for(int i = 0; i < into.length; i++)
        {
            System.out.println(into[i]);
        }
        System.out.println("-------trim--------");
        String s6 = "       a bc     ";
        s6 = s6.trim(); // 去掉字符串前后的空格
        System.out.println(s6+ "\n长度: " + s6.length());
        System.out.println("-------类型转换--------");
        String s = "1233425";
        int x;
        x = Integer.parseInt(s);    // 将 字符换转换为 int 类型，但是字符串中不能有除了数字之外的字符
        System.out.println(x);
        String number_str;
        number_str = String.valueOf(x); // 将 int 类型的数字转换为 字符串，参数可以为 doule\long\float等
        System.out.println(number_str);
        System.out.println(Long.toString(x,16));    // Long.toString 将一个整数转换为 任意进制 的数字
        System.out.println("-------字符串转换为字符存储到字符数组中--------");
        char Ch[] = new char[5];
        s.getChars(0,3,Ch,1);
        // getChars() 函数
        // 将当前字符串的一部分字符复制到参数 ch 指定的数组中，将字符串从start到end-1位置上的字符复制到数组c中，并从 ch 的offset位置开始存储。
        for(int i = 0; i < Ch.length; i++)
            System.out.println(Ch[i]);
    }
}
