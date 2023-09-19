package Program.bookManager.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ToolUtils {    // �ַ����Ƿ�Ϊ��
    public static boolean isEmpty (String str) {
        if (str.trim().length() == 0)
            return true;
        return false;
    }

    public static Long getTime() {  // ��ȡ��ǰʱ������Ӧ�ĺ���ֵ
        return System.currentTimeMillis();
    }

    public static String getDateByTime(Long sec) throws ParseException {   // �� Long ���͵ĺ���ֵת��Ϊ ָ����ʽ����
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date(sec);
        String dateString = format.format(date);
        return dateString;
    }
}
