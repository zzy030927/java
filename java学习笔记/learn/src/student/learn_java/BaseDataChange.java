package student.learn_java;

// �������͵�ת��
public class BaseDataChange {
//   ��ʽת�����Զ�������������ȡֵ��ΧС������ת��Ϊȡֵ��Χ�������
//   ǿ��ת����ȡֵ��Χ�������ת��Ϊȡֵ��ΧС������
//   ȡֵ��Χ: byte < short �� char < int < long < float < double��ȡֵ��Χ���
    public static void main(String[] args) {
//      ��ʽת��������ת������
//      �� ��������С�ĺ��������ʹ�Ľ��������ʱ��С���������ͻ���������������������ڽ�������
//      �� byte\short\char �����������ڽ�������ʱ�������Զ�����Ϊ int�ٽ�������
        char a = 1; // byte �����Զ�����Ϊ char,��Ϊ byte ���� short����ת����,�������� byte ����������ӻ��Զ�����Ϊ int ���ͣ��ο��ڶ�������
        float b = 2;
        b = a;
        byte c = 1;
        byte d = 2;
        int i = c + d; // ����ֵ����Ϊ int
        char f = 3;
        int i1 = a + f; // ͬ�� ���� int

        short a1 = 3;
        byte a2 = 4;
        int i2 = a1 + a2; // ע����Ϊ int, ���� short
//      ǿ��ת����
        byte b1 = (byte) (c + d);
    }

}
