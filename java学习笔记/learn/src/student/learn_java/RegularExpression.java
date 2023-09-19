package student.learn_java;
import java.util.regex.Pattern; // ƥ���ģʽ
import java.util.regex.Matcher; // ƥ��Ľ��


// ������ʽ
// . ��ʾ�����ַ�
// * ��ʾ 0 - ����ַ�
// + ��ʾ 1 - ����ַ�
// ? ��ʾ 0 ���� 1���ַ�
// {a,b} ��ʾ������ a �� b֮��,Ĭ�� a Ϊ 0
// [a-b] ��ʾ����ֵ�� a �� b ֮��
// [] ���� ƥ������������һ���ַ���   ���� [abc] ƥ�� a\b\c ����һ��
// [^] ���� ���������ڵ��ַ������Ա�ƥ�䣬����һ��ȡ������
// \r �س�
// \\s ��ʾ���пհ��ַ�
// \\S ��ʾ���зǿհ��ַ��� \\S ��ʾһ���ַ������˿հ�
// \\w ƥ��һ�������Сд���ַ���_������
// \\W �� \\w �෴
// ^h �� h�ַ���ͷ
// h$ �� h�ַ���β
// \\b �ָ���
// [.-] �� . ���ӣ����磺 [\\w[.-]]* �������ַ�֮���� . ����,���磺 cg.av.dage.wer

public class RegularExpression
{
    public static void main(String[] args)
    {
        // matches() ������    regex ������ʽ������ַ�����������ʽƥ�䣬��ô���� true
        System.out.println("123".matches("12."));
        // replaceAll(regex, replacement); ��һ������Ϊ ������ʽ \d Ϊ 0-9�����֣� ��һ�� \ ʹ \ ������һ��ת���ַ�
        System.out.println("a21343132abc".replaceAll("\\d", "-"));
        String regex = "2";
        System.out.println("a21343132abc".replaceAll(regex, "-"));
        System.out.println("-------ȡ������--------");
        System.out.println("3134".matches("[^2]*"));
        System.out.println("-------ƥ�����зǿհ��ַ�--------");
        System.out.println(" ".matches("\\S"));
        System.out.println("1234".matches("\\S.*"));
        System.out.println("-------\\w--------");
        System.out.println("a_8".matches("\\w_\\d"));
        System.out.println("-----Pattern��Matcher��ʹ��----");
        Pattern pa = Pattern.compile("\\d*");   // Pattern �����ڴ���һ��������ʽ
        Matcher ma = pa.matcher("123567");      // �ô�����������ʽ Ԥƥ�� ������ַ���,��һ����������ƥ�䣬����һ��ƥ������ Matcher
        System.out.println(ma.matches());             // Matcher ������һ������ matchers() ����ƥ�䴴����������ʽ�� ������ַ����Ƿ����
        String test1 = "Java1234";
        String test2 = "1234Java";
        Pattern pattern = Pattern.compile("Java");
        Matcher matcher = pattern.matcher(test1);
        System.out.println("-----Matcher����lookingAt()��find()------");
        System.out.println(matcher.lookingAt());    // lookingAt()���ַ�����ʼƥ����������ʽ��ͬ���ִ�������У����� true
        Matcher matcher1 = pattern.matcher(test2);
        System.out.println(matcher1.lookingAt());   // ��ʼƥ��ʧ�ܣ����� false
        System.out.println(matcher1.find());        // ������λ�ÿ�ʼƥ���ַ����ִ�
        System.out.println(matcher1.find(5));  // �� start ��ʼλ�ÿ�ʼƥ���ַ����ִ��¡�
        System.out.println("-------Matcher����start()��end()��group()-------");
        matcher1.find();    // ʹ�� start() ����ǰҪ�� find Ѱ���ִ�һ��
        System.out.println(matcher1.start());   // ���ƥ��ɹ������� ƥ��ɹ��Ŀ�ʼλ�ã����ƥ��ʧ�ܣ���ô����
        System.out.println(matcher1.end());     // ����ƥ��ɹ��Ľ���λ��
        System.out.println("-------Matcher����region()------");
        matcher1.region(0,6);   // ����ƥ��ķ�Χ
        System.out.println(matcher1.regionStart()); // ����������Χ�Ŀ�ʼλ��
        System.out.println(matcher1.regionEnd());   // ����������Χ�Ľ���λ��
        System.out.println(matcher1.find());
        System.out.println("--------Matcher���е�replaceAll()��replaceFirst()--------");
        String test3 = "Java123456Java";
        Matcher matcher2 = pattern.matcher(test3);
        System.out.println(matcher2.replaceAll("Python"));  // �滻ȫ��ƥ���ϵ��ַ��ִ�
        System.out.println(matcher2.replaceFirst("C++"));   // �滻��һ��ƥ���ϵ��ַ��ִ�
        System.out.println("------Matcher���е�appendReplacement()��appendTail()-------");
        Pattern pattern3 = Pattern.compile("Java");
        Matcher matcher3 = pattern3.matcher("Java1234");
        System.out.println(matcher3.find());//����true
        StringBuffer sb = new StringBuffer();
        matcher3.appendReplacement(sb, "Python");   // ��ƥ�䵽���ַ��Ӵ���ӵ� sb ʵ����
        System.out.println(sb);//���Python
        matcher3.appendTail(sb);                                // �� δƥ�䵽�� �ַ��Ӵ���ӵ� sb ʵ����
        System.out.println(sb);//���Python1234
    }
}
