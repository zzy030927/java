package Program.bookManager.utils;

import Program.bookManager.model.User;
import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ToolUtils {    // �ַ����Ƿ�Ϊ��
    public static boolean isEmpty(String str){
        if(str != null && !"".equals(str.trim())){
            return false;
        }
        return true;
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
    public static User getUser(HttpSession session){
        User user = (User) session.getAttribute("user");
        return user;
    }
    public static void setUser(HttpSession session,User user){
        session.setAttribute("user", user);
    }
}
