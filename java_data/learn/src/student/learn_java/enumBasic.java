package student.learn_java;

import java.util.Arrays;

// 枚举类基础
enum enumDefine {
    ZHANGSAN,
    LISI,
    WANGWU
}

public class enumBasic {
    public static void main(String[] args) {

        System.out.println("------直接调用-----");
        System.out.println(enumDefine.ZHANGSAN);    // 直接调用

        System.out.println("------values()-----");
        for(int i = 0; i < enumDefine.values().length; i++) // 遍历
            System.out.println(enumDefine.values()[i]); // 使用索引进行访问

        System.out.println("------switch()-----");
        switch(enumDefine.ZHANGSAN){    // switch() 使用
            case ZHANGSAN :
                System.out.println(1); break;
            case LISI :
                System.out.println(2); break;
            case WANGWU :
                System.out.println(3); break;
        }

        System.out.println("------ordinal()-----");
        System.out.println(enumDefine.LISI.ordinal());  // ordinal() 用于返回值的索引

        System.out.println("------compareTo()-----");
        System.out.println(enumDefine.ZHANGSAN.compareTo(enumDefine.WANGWU));   // compareTo() 返回两个索引之间的差值

        System.out.println("------valueOf()-------");
        System.out.println(enumDefine.valueOf("ZHANGSAN"));     // valueOf(String name) 查询 name 是否为 枚举类型中的值，如果是那么打印，否则

        System.out.println("-------格式化输出-------");
        System.out.println(Arrays.toString(enumDefine.values()));     // 格式化输出


    }
}
