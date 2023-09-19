package student.learn_java;
import java.lang.*;

// StringBuilder ��ʹ�� -- StringBuilder ������� StringBuffer ��Ĳ�֮ͬ�����ڣ�StringBuilder ����߳��ǲ���ȫ�ģ�
// �� StringBuffer ���߳��ǰ�ȫ�ģ����� StringBuffer �������ٶȱ� StringBuilder ��
public class StringBuilderTest
{
    public static void main(String[] args)
    {
        System.out.println("----append()----");
        StringBuilder sb1 = new StringBuilder("��ѧ");    // �������������
        sb1.append("��");
        sb1.append(0);  // 0 �Զ�תΪΪ String ����
        char aa[] = {'1','2','3','4','5','6'};
        sb1.append(aa);     // ����ַ�����
        System.out.println(sb1);
        System.out.println("-----setCharAt()-----");
        sb1.setCharAt(0, 'ѧ');
        sb1.setCharAt(1, 'Ժ');
        System.out.println(sb1);
        System.out.println("-----insert()-----");
        sb1.insert(0, "����");
        System.out.println(sb1);
        System.out.println("-----delete()-----");
        sb1.delete(5,10);
        System.out.println(sb1);
        System.out.println("-----deleteCharAt()-----");
        sb1.deleteCharAt(5);
        System.out.println(sb1);
        System.out.println("-----replace()-----");
        sb1.replace(0,4,"");
        System.out.println(sb1);
    }
}
