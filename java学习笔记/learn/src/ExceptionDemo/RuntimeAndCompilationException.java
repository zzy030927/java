package ExceptionDemo;

// �쳣����ĸ���Ϊ Exception����������п��ܳ��ֵ�����
// ��������ĸ���Ϊ Error������ϵͳ����Ĵ���
// Exception �� Error �ĸ���Ϊ Throwable

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

// Exception�����е� ����ʱ�쳣������RuntimeException������쳣�� �� ����ʱ�쳣 RuntimeException
public class RuntimeAndCompilationException {
    public static void main(String[] args) throws ParseException {
        // ����ʱ�쳣
        String time = "2030��09��15��";
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy��MM��dd��");
        Date date = dateFormat.parse(time); // ����ʱ�쳣Ҫ�ֶ�����,�׳����߲�׽
        System.out.println(date);

        // ����ʱ�쳣
        int[] nums = {1, 3, 4, 5, 6};
        System.out.println(nums[5]);    // ����Խ��,����ʱ����

    }
}
