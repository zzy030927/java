package student.learn_java;

public class string
{
    public static void main(String[] args)
    {
        // s1 ָ�����ַ��� "ABCd-AFG,CA"�ĵ�ַ
        String s1="ABCd-AFG,CA";
        String s2="AccD-";
        // ��String �๹������
        String s3 = new String(s1);
        System.out.println("String �ഴ������: " + s3);
        char ch[] = {'a','b','c','d'};
        String s4 = new String(ch,1,2); //�� ch ����� offset ��ʼ������Ϊ count ���� String����
        System.out.println("��char�������鴴��String�����: " +s4);
        System.out.println("-------equals()�� == ������--------");
        // equal() �Ƚϵ��������ַ�����ֵ�Ƿ����
        // �� == �Ƚϵ��������ַ����ĵ�ַ�Ƿ����
        String eq = new String("123");
        String eq1 = new String("123");
        System.out.println(eq == eq1);  // false, ��Ϊ ���� ʹ new ������ ֵΪ 123 �Ķ����������ĵ�ַ�ǲ�һ����
        System.out.println(eq.equals(eq1)); // true  equals()�Ƚϵ�������ʵ����ֵ�Ƿ����
        String e1 = "123";
        String e2 = "123";
        System.out.println(e1 == e2);   // true�����ｫ ���� 123 �ĵ�ַ��ֵ�� e1 �� e2 ������ e1 == e2 Ϊ true
        System.out.println("-------equalsIgnoreCase--------");
        System.out.println(s1.equalsIgnoreCase(s2));    // �ж������ַ����Ƿ���ȣ����ִ�Сд
        System.out.println("-------StatrsWith--------");
        System.out.println(s1.startsWith("AB"));        // �ж��Ƿ��Ը��ַ�����ʼ
        System.out.println(s1.endsWith("CD"));          // �ж��Ƿ��Ը��ַ�����β

        boolean c = false;
        System.out.println("-------regionMatches--------");
        c = s1.regionMatches(true, 1, s2, 1, 3);
        // regionMatches(boolean b, int firstStart, String other, int otherStart, int length)
        // �ӵ�ǰ�ַ�����firstStart��ʼ��ȡ����Ϊlength��һ���ַ�����
        // other��otherStartλ��Ҳȡһ������Ϊlength���ַ��������ַ������бȽϡ�
        // ��bΪtrueʱ�����ַ��������ִ�Сд��
        System.out.println(c);
        System.out.println("-------compare--------");
        System.out.println(s1.compareTo(s2));
        // compareTo �ȽϺ���������һ���ֵ�Ƚ������ַ��������� s1 �� s2 ֮���һ����ͬ�ַ�֮��Ĳ�ֵ
        System.out.println("-------contain--------");
        System.out.println(s2.contains("AD"));  // ����ַ������Ƿ���� ac
        System.out.println("-------indexOf--------");
        System.out.println(s1.indexOf("AB"));   // ��� "AB" �� s1 �ַ����е�һ�γ��ֵ�λ�ã�û�з��� -1
        System.out.println(s1.indexOf("C",2));
        //������Ϊ 2 ��λ�ÿ�ʼ���� �ַ� C,�������״γ��ֵ�λ�á�

        System.out.println(s1.lastIndexOf("c",2));
        // ���ַ�����ͷ��ʼ�������� fromIndex ��λ�ý��������� �ַ��� "c" ��һ�γ��ֵ�λ�ã�
        // fromIndex ����Ĭ��Ϊ�ַ����ĳ���

        String s5;
        s5 = s1.substring(1,3);   // ������λ��Ϊ 1 ��λ�ÿ�ʼ��ȡ�ַ�����ֵ�� s5,�� ����λ�� 3����
                                    // ����λ��Ĭ��Ϊ �ַ����ĳ���
        System.out.println(s5);
        System.out.println("-------�ָ��ַ���--------");
        String []into;
        into = s1.split("-|,");     // '|' �ǻ���
        // ���ַ��� '-' ���� ',' �ָ��ַ��� s1, ������ַ������鸳ֵ�� into
        for(int i = 0; i < into.length; i++)
        {
            System.out.println(into[i]);
        }
        System.out.println("-------trim--------");
        String s6 = "       a bc     ";
        s6 = s6.trim(); // ȥ���ַ���ǰ��Ŀո�
        System.out.println(s6+ "\n����: " + s6.length());
        System.out.println("-------����ת��--------");
        String s = "1233425";
        int x;
        x = Integer.parseInt(s);    // �� �ַ���ת��Ϊ int ���ͣ������ַ����в����г�������֮����ַ�
        System.out.println(x);
        String number_str;
        number_str = String.valueOf(x); // �� int ���͵�����ת��Ϊ �ַ�������������Ϊ doule\long\float��
        System.out.println(number_str);
        System.out.println(Long.toString(x,16));    // Long.toString ��һ������ת��Ϊ ������� ������
        System.out.println("-------�ַ���ת��Ϊ�ַ��洢���ַ�������--------");
        char Ch[] = new char[5];
        s.getChars(0,3,Ch,1);
        // getChars() ����
        // ����ǰ�ַ�����һ�����ַ����Ƶ����� ch ָ���������У����ַ�����start��end-1λ���ϵ��ַ����Ƶ�����c�У����� ch ��offsetλ�ÿ�ʼ�洢��
        for(int i = 0; i < Ch.length; i++)
            System.out.println(Ch[i]);
    }
}
