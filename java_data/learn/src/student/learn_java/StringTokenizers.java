package student.learn_java;
import java.util.*;

// StringTokenizer ������ã�����һ������������һ���ַ������Ϊ������ʡ�
public class StringTokenizers
{
    public static void main(String[] args)
    {
        String str = "we are student";
        StringTokenizer st = new StringTokenizer(str);  // Ĭ�� �ո� Ϊ�ָ��ַ����ı��
        // StringTokenizer stringTokenizer = new StringTokenizer(str, ",");     �ı�Ϊ , Ϊ�ָ��ַ����ı��
        int number = st.countTokens();  // ��ȡ�ָ�ĵ�������
        while(st.hasMoreElements())     // �жϻ���û����һ������
        {
            String word = st.nextToken();   // ���ص�ǰ�ĵ��ʣ�����ת����һ������
            System.out.println(word);
            System.out.println("��ʣ" + st.countTokens() + "������");
        }
    }
}
