package CollectionDemo;

interface Sub{  // һ���ӿ���ֻ��һ����������ô����ӿھͱ���Ϊ����ʽ�ӿڣ���ô�ſ���ʹ�� Lambda ���ʽ
    void add1();
}

interface Sum{  // ����ӿڲ���ʹ�� Lambda ���ʽʵ��
    void add();
    void mul();
}

interface Test1{
    void pri(String name);
}

interface Test2{
    int abs1(int a);
}

// Lambda ��һ�������������
public class Lambda {
    public static void main(String[] args) {
        System.out.println("----�޲�----");
        Sub num = () -> {   // Lambda ��ʹ��
            System.out.println("1");
        };
        num.add1();

        System.out.println("----�в�----");
        Test1 test = (name) -> {    // ����Ĳ���Ҫ�ͽӿ��к����� �������� ��ͬ
            System.out.println(name);
        };
        test.pri("zhang");  // ��������д���

        System.out.println("----�����������еľ�̬����---");

    }

}
