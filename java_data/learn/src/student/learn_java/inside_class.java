package student.learn_java;

// �ڲ��࣬������һ���༴�ڲ���

//�ڲ������ֱ�ӷ����ⲿ��ĳ�Ա������˽��
//�ⲿ��Ҫ�����ڲ���ĳ�Ա�����봴������
//�ֲ��ڲ��� : ����һ����� ������ �� �ж���һ����,����ֱ�ӷ����ⲿ�ĳ�Ա�������Է��ʷ����������Ը���Աֵ�޸ĺ͸�ֵ


class Outer // �������� �ڲ��� �� ʹ��
{
    int number;
    private int age;
    class Inner
    {
//        static int a = 5;     jdk16 ���²�֧�� �ڲ���������̬�����;�̬����
        public String name;
        void setname(String name)
        {
            this.name = name;
        }
        void show()
        {
            age = 18;   // �ڲ���ֱ�ӷ���
            number = 3;
            System.out.println(age + " " + name);
        }
    }
    // name = "z"; �ڲ����� ����ֱ�ӷ���
    void get()  // �ڲ����ʹ��
    {
        Inner in = new Inner();
        in.setname("zhang");
        in.show();
    }
}


class local_outer   // �������� �ֲ��ڲ��� �� ʹ��,�ֲ��ⲿ�� �ⲿ �޷�ֱ��ʹ��
{
    private int age;
    int number;
    int num = 3;
    int re()
    {
        return age;
    }
    void set(int age,int number)
    {
        this.age = age;
        this.number = number;
    }

    void get()  // �ڱ�������ʵ����һ�� �ⲿ�� ���󣬿����ô˶�������ⲿ��ķ�����������
    {
        int num = 20;
        local_outer loc = new local_outer();
        class local_inner_class
        {
            int num = 1;
            void play()
            {
                System.out.println("��");
            };
            void show()
            {
                System.out.println(num);    //  ���������𼶵���
                System.out.println(age);
                System.out.println(number);
                play();     // ���Ե��þֲ��ڲ����еķ���
                loc.set(12, 3);
            }
        }

        local_inner_class lo = new local_inner_class();
        lo.show();
        // lo.re(),lo.set(), age = 18; ������ʹ��
    }

}

public class inside_class
{
    public static void main(String[] args)
    {
        System.out.println("-----�ڲ���ʹ��----");
        Outer ou = new Outer();
        ou.get();
        System.out.println("Outer Number = " + ou.number);  // ֤������ֱ�ӷ���
        //��紴����Ա�ڲ����ʽ
        Outer.Inner inn = new Outer().new Inner();
        inn.setname("1111");
        inn.show();

        System.out.println("-----�ֲ��ڲ���ʹ��----");
        local_outer loc = new local_outer();
        loc.set(18,1);
        loc.get();  // �ֲ��ڲ����ʹ��
    }
}
