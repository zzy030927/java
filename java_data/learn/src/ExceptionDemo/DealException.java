package ExceptionDemo;

// 处理异常
// JVM 默认把异常名称、异常信息、异常位置等信息输出在控制台，同时停止代码运行
// 自己处理异常 try/catch捕捉,可以继续让程序执行，不会停止
public class DealException {
    public static void main(String[] args) {
        try {
            System.out.println("狂踹瘸子那条好腿");
            System.out.println(2/0);    // 异常出现后下面代码不会运行
            System.out.println("火锅味鸡巴");
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
        System.out.println("火鸡味锅巴");
    }
}
