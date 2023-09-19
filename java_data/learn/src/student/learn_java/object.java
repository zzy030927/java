package student.learn_java;
// object : ����
// Object �� �������� �� ������ ����
// �� Object�� ���ж���(��������)��ʵ�������ķ���

// Object �ೣ�÷���: ����������������д
// toString() : Ĭ�Ϸ��� @��ַ �ĸ�ʽ������չʾ����ĵ�ַ
// hashCode() : ���ڻ�ȡ�����ɢ��ֵ�����ص��Ƕ���Ķ��ڴ��ַ
// equals() : �Ƚ�����������ͬ���� true
// clone() : ǳ����
// finalize() : ���������������

class Person
{
    private String name;
    private int age;
    private double salary;
    private String addr;
    public Person(){};
    public Person(String name, int age, double salary, String addr)
    {
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.addr = addr;
    }
    public String toString(String name, int age, int salary, String addr)   // ��д toString() ����
    {
        return "Person [name = " + name + ", age = " + age + ", salary = " + salary + ", addr = " + addr + "]";
    }

}

public class object
{
    public static void main(String[] args)
    {
        Person p1 = new Person("zhang", 20, 10, "cangzhou");
        System.out.println(p1.toString());   // ���ص�ַ
        System.out.println(p1.toString("zhang", 20, 10, "cangzhou")); // ������д����

        Person p2 = new Person("liu", 21, 12, "cangzhou");
        System.out.println(p1.equals(p2));  // �ж����������Ƿ����

        System.out.println(p1.hashCode());  // ���ض���� ��ϣ��ַ
    }
}
