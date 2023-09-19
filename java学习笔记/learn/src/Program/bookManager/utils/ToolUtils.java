package Program.bookManager.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ToolUtils {    // 字符串是否为空
    public static boolean isEmpty (String str) {
        if (str.trim().length() == 0)
            return true;
        return false;
    }

    public static Long getTime() {  // 获取当前时间所对应的毫秒值
        return System.currentTimeMillis();
    }

    public static String getDateByTime(Long sec) throws ParseException {   // 将 Long 类型的毫秒值转换为 指定格式日期
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date(sec);
        String dateString = format.format(date);
        return dateString;
    }
}
