package ExceptionDemo;

// 异常最顶级的父类为 Exception，代表程序中可能出现的问题
// 错误最顶级的父类为 Error，代表系统级别的错误
// Exception 和 Error 的父类为 Throwable

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

// Exception子类中的 编译时异常（除了RuntimeException以外的异常） 和 运行时异常 RuntimeException
public class RuntimeAndCompilationException {
    public static void main(String[] args) throws ParseException {
        // 编译时异常
        String time = "2030年09月15日";
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy年MM月dd日");
        Date date = dateFormat.parse(time); // 编译时异常要手动处理,抛出或者捕捉
        System.out.println(date);

        // 运行时异常
        int[] nums = {1, 3, 4, 5, 6};
        System.out.println(nums[5]);    // 数组越界,运行时报错

    }
}
