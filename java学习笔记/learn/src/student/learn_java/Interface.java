package student.learn_java;

//�ӿ�
//�ӿڹؼ����� interface ����
// ��ʵ�ֽӿ��� implements ��ʾ
//�ӿڲ���ʵ����

//�ӿ����ʵ�����أ����ն�̬�ķ�ʽ��ͨ��ʵ�������ʵ��������нӿڶ�̬��

//��̬����ʽ���������̬���������̬���ӿڶ�̬��

//�ӿڵ�����
// Ҫô��д�ӿ��е����г��󷽷�
// Ҫô����Ҳ�ǳ�����

//12.3 �ӿڵĳ�Ա�ص�
//��Ա�ص�
//��Ա����
// ֻ���ǳ���
// Ĭ�����η���public static final, ϵͳ��Ĭ�ϼ���

//���췽��
//û�У���Ϊ�ӿ���Ҫ����չ���ܵģ���û�о������

//��Ա����
//ֻ���ǳ��󷽷�
//Ĭ�����η���public abstract

//�������ʵ���˽ӿ��е�ȫ����������ô���಻��ʹ�� implements �̳�����ӿڡ�

interface In
{
    public final static int a = 4;     // Ĭ�� public final static��һ�����־�̬�����ͺ����Ͳ��ǽӿ��ڲ��ı����ͺ�������Ϊ���Ǿ�̬��
    int b = 5;
    // b = 4;
    public String name=  "1";
    int c = 2;


    // ��̬����ֻ��ͨ�� �ӿ���.��̬���� �����ã�����ͨ������������ʵ�����������ã����Ҿ�̬�������ñ�ʵ������д
    public static void pr(){ System.out.println("��̬����: " +123);};
    default void pr1(){System.out.println("Ĭ�Ϸ���: " +456);};       // Ĭ�Ϸ�������ǿ������ȥ��д����� ��̬������Ĭ�Ϸ��������ǿ��Ա�����
    // ��ͨ˽�з���
    private void pr2() {
        System.out.println("�ӿ��е���ͨ˽�з���");
    }

    // ��̬˽�з���
    private static void pr3() {
        System.out.println("�ӿ��о�̬˽�з���");
    }

    default void pr4() {
        pr2();
        pr3();
    }

    void display(); // ���󷽷���Ĭ�� public abstract
    void In();      // ���ǹ��캯��
}

interface In1
{

}

class te
{

}

// ��̳нӿ�
// abstract class Im extends te implements In �ȼ̳����̳нӿ�
class Im implements In,In1  // �ӿڿɶ�̳�
{
    public void display()
    {
        // name = "1"; �����޸�
        System.out.println(name);   // ������Է���
    }
    public void In()
    {
        System.out.println("In����");
    }
}

// �ӿڻص� : �и��ӿ� A�� A �и�ʵ���� Almpl, �� Almpl �� ���������� a() �� c(),
// �и� B �࣬ B�����и����� b()��
// �ӿڻص����� Almpl ����ͨ������ a() ���� B���е� ���� b() ,�ڷ��� b() �� �лص� Almpl ���е� ���� c()

// ͬ���ص� : ���� b() ���߼�ִ������ȥִ�з��� c()
// �첽�ص� : ���� b() �� ���� c() һ��ִ��

interface CallBack  // �ӿ� A
{
    boolean consider(int money);// �յ�Ǯ���˼����ʽ
    void payFor(int money);     // ˼��Ҫ��Ҫ��Ǯ
}

class Passenger_Impl implements CallBack    // ʵ���� Almpl
{
    public boolean consider(int money)
    {
        boolean result = true;
        if(money > 60)
        {
            result = false;
            System.out.println(money + "̫����");
        }
        return result;
    }

    public void payFor(int money)           // c() ����
    {
        System.out.println("OK, " + money + "����");
    }

    public void takeTaxi(Driver driver)         // a() ����
    {
        System.out.println("ʦ��, ȥ����һ�����Ǯ");
        driver.answer(this);            // �ѱ��ഫ�ݸ� B ���е� b() ����
    }
}

class Driver
{
    public void answer(CallBack callBack)
    {
        System.out.println("ȥ����60");
        if(callBack.consider(60))
        {
            callBack.payFor(60);       // �ص� Almpl ���е� c() ����
        }
    }
}

public class Interface
{
    public static void main(String[] args)
    {
        In i = new Im();    // �ӿ�û�й��캯��,�ö�̬���ʱ����ͺ���
        i.display();
        System.out.println("-------�ӿڻص�--------");
        Passenger_Impl passenger = new Passenger_Impl();
        Driver driver = new Driver();
        passenger.takeTaxi(driver);
        System.out.println("-------Ĭ�Ϻ����;�̬����--------");
        In in = new Im();
        in.pr1();     // Ĭ�Ϸ���
        In.pr();      // ��̬����
        i.pr4();
        System.out.println("��̬�����޸ĵı���: " + In.a +"," + In.b + "," + In.c + "," + In.name);
    }
}
//������Ĺ�ϵ
// �̳й�ϵ��ֻ�ܵ��̳У����ǿ��Զ��̳�

//����ӿڵĹ�ϵ
// ʵ�ֹ�ϵ�����Ե�ʵ�֣�Ҳ���Զ�ʵ�֣��������ڼ̳�һ�����ͬʱʵ�ֶ���ӿ�

//�ӿ���ӿڵĹ�ϵ
// �̳й�ϵ�����Ե��̳У�Ҳ���Զ�̳�

//������ͽӿڵ�����

//��Ա����
//������
// ����,�������й��췽�����г��󷽷�,Ҳ�зǳ��󷽷�
//�ӿ�
// ���������󷽷�

//��ϵ����
//������
// �̳У����̳�

//����ӿ�
// ʵ�֣����Ե�ʵ�֣�Ҳ���Զ�ʵ��

//�ӿ���ӿ�
// �̳У����̳У���̳�

//�����������
//������
// ������󣬰������ԡ���Ϊ

//�ӿ�
// ����Ϊ������Ҫ����Ϊ
