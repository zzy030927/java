package student.learn_java;

import java.text.SimpleDateFormat;
import java.util.Date;

public class date
{
    public static void main(String[] args)
    {
        // 生成一个Date对象，里面是现在的时间
        System.out.println("------生成一个Date()对象------");
        Date nowTime = new Date();
        System.out.println("现在时间: " + nowTime);
        // Date里面参数为 int 类型，那么返回的参数为 1970年 1 月 1 日 8时 0 分 0秒 + 填入的毫秒数
        Date date = new Date(1000);
        System.out.println(date);
        // 一般的ASC字符要单引号
        System.out.println("------格式化时间 SimpleDateFormat()类-----");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("'Now Time:' y年M月d日H时m分s秒");   // 生成一个格式化对象
        String format = simpleDateFormat.format(nowTime);   // 格式化时间 nowTime
        System.out.println(format);
        // G = 公元 E = 星期
        SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("'Now Time:' Gyyyy年MM月EHH时mm分ss秒");
        String format1 = simpleDateFormat1.format(nowTime);
        System.out.println(format1);
        // 将当前时间转换为毫秒
        System.out.println("-----将时间转换为毫秒-----");
        long l = System.currentTimeMillis();    // 返回从 1970年 1 月 1 日 8时 0 分 0秒 到现在的毫秒数
        System.out.println("从"+simpleDateFormat.format(new Date(1000))+"到现在是："+ l + "毫秒");
    }
}
