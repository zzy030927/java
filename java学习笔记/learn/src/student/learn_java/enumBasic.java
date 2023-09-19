package student.learn_java;

import java.util.Arrays;

// ö�������
enum enumDefine {
    ZHANGSAN,
    LISI,
    WANGWU
}

public class enumBasic {
    public static void main(String[] args) {

        System.out.println("------ֱ�ӵ���-----");
        System.out.println(enumDefine.ZHANGSAN);    // ֱ�ӵ���

        System.out.println("------values()-----");
        for(int i = 0; i < enumDefine.values().length; i++) // ����
            System.out.println(enumDefine.values()[i]); // ʹ���������з���

        System.out.println("------switch()-----");
        switch(enumDefine.ZHANGSAN){    // switch() ʹ��
            case ZHANGSAN :
                System.out.println(1); break;
            case LISI :
                System.out.println(2); break;
            case WANGWU :
                System.out.println(3); break;
        }

        System.out.println("------ordinal()-----");
        System.out.println(enumDefine.LISI.ordinal());  // ordinal() ���ڷ���ֵ������

        System.out.println("------compareTo()-----");
        System.out.println(enumDefine.ZHANGSAN.compareTo(enumDefine.WANGWU));   // compareTo() ������������֮��Ĳ�ֵ

        System.out.println("------valueOf()-------");
        System.out.println(enumDefine.valueOf("ZHANGSAN"));     // valueOf(String name) ��ѯ name �Ƿ�Ϊ ö�������е�ֵ���������ô��ӡ������

        System.out.println("-------��ʽ�����-------");
        System.out.println(Arrays.toString(enumDefine.values()));     // ��ʽ�����


    }
}
