package student.learn_java;
//������
//�������������๲�Թ��ܳ�ȡʱ����Щ�����ڸ����в�û�о�������֣����ʱ�����Ҫ�������ˣ�
//��Java�У�һ��û�з�����ķ���Ӧ�ö���Ϊ���󷽷�������������г��󷽷���������붨��Ϊ�����࣡
//�������в�һ���г��󷽷����г��󷽷�����һ���ǳ�����

//�����಻��ʵ����
//���������ʵ�����أ����ն�̬�ķ�ʽ��ͨ���������ʵ��������г������̬

//��Ա���ص�
//
//��Ա����
//�ȿ����Ǳ���
//Ҳ�����ǳ���
//���췽��
//�ղι���
//�вι���
//��Ա����
//���󷽷�
//��ͨ����

//�����������
//Ҫô��д�������е����г��󷽷�
//Ҫô�ǳ�����

//������������ã� ��д�����еĳ��󷽷���Ҫô�Լ�����һ�������ࡣ


abstract class Ab
{
    public int a;
    public   String name = "111";
    public abstract void eat();
    public void Ab(){};
    public void Ab(int a){
        this.a = a;
    };
    public void teach()
    {
        System.out.println("��");
    }
}

class ab extends Ab
{
    public void eat()
    {
        System.out.println("��");
    }
}


public class ClassAbstract
{
    public static void main(String[] args)
    {

    }
}
