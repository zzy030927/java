package student.learn_java;

// 数据类型的转换
public class BaseDataChange {
//   隐式转换（自动类型提升）：取值范围小的类型转换为取值范围大的类型
//   强制转换：取值范围大的类型转换为取值范围小的类型
//   取值范围: byte < short 和 char < int < long < float < double（取值范围最大）
    public static void main(String[] args) {
//      隐式转换的两种转换规则：
//      ① 数据类型小的和数据类型大的进行运算的时候，小的数据类型会先提升到大的数据类型在进行运算
//      ② byte\short\char 这三种类型在进行运算时，都会自动提升为 int再进行运算
        char a = 1; // byte 不能自动提升为 char,因为 byte 是向 short进行转换的,并且两个 byte 类型数据相加会自动提升为 int 类型，参考第二条规则
        float b = 2;
        b = a;
        byte c = 1;
        byte d = 2;
        int i = c + d; // 返回值类型为 int
        char f = 3;
        int i1 = a + f; // 同理 返回 int

        short a1 = 3;
        byte a2 = 4;
        int i2 = a1 + a2; // 注意结果为 int, 不是 short
//      强制转换：
        byte b1 = (byte) (c + d);
    }

}
