package student.learn_java;
import java.lang.*;

//�����ഫ����Ҫ��������
// ����ʱ���ص��ǳ�������

//�ӿ�������ഫ�Ρ����ز������ƣ�
// ������Ǹýӿڵ�ʵ�������
// ���صĵ��Ǹýӿڵ�ʵ�������

/*
    ��������ӿڵ�����
        �ӿ����ر�ĳ����࣬
        �������п����г��󷽷�����ͨ������ �ӿ���ֻ�����г��󷽷���
        �������п����г�Ա�����ͳ����� �ӿ���ֻ���� final static ��̬�����޸ı���
        �������п����й��캯�������ǽӿ���û�й��캯��

 */

abstract class Fa    // ������
{
    public String name;
    abstract void eat();    //���󷽷�
    public Fa(){};
    public Fa(String name)
    {
        this.name = name;
    };
}

class Son extends Fa
{
    public Son(){};
    public Son(String name)
    {
        super(name);
    }
    public void eat()
    {
        System.out.println(name + " �Է�");
    }
    void sport()
    {
        System.out.println("�˶�");
    }
}

class FaAndSon
{
    void get(Fa fa)
    {
        fa.eat();
    }
    Fa re()
    {
        Fa f=  new Son();   // ���ص����������
        return f;
    }
}

public class abstract_sonClass
{
    public static void main(String[] args)
    {
        Fa f = new Son("zhang");
        f.eat();

        FaAndSon F = new FaAndSon();
        F.get(f);

        Fa new_f = new Son();
        new_f = F.re(); //���������������������
        new_f.eat();
    }
}
