package student.learn_java;

// ���� ��Reflection�����䣩�������������е� java �����������м�飬�� private ��װ����Դֻ�ܱ����ڲ����ʣ��ⲿ�ǲ��е�
// ���Ƿ�����ֱ�Ӳ������ڲ�˽�����ԣ��������������ʱ��ȡһ�������Ϣ����������Ա��������Ա�������������ȣ�
// ��Ҫ����һ���࣬�����Ȼ�ȡ��������ֽ����ļ����󡣶�����ʹ�õľ��� Class���еķ���������Ҫ�Ȼ�ȡ��ÿһ���ֽ����ļ������ Class���͵Ķ���

// ������ǰ� java���еĸ��ֳɷ�ӳ���һ������ java ����
// ���磺idea���Զ���ʾ���ܾ����� ����ʵ�ֵģ�������ʾһ�������β�Ҳ��ͨ������ ctrl+p
// ������Ǵ��������ö��������Ի�ȡ�����е���Ϣ���������֡����͡����η����βΡ��׳����쳣�ȵ�

// ��ȡ class �ļ������ַ���:
// 1. Class.forName("ȫ����");     Class �࣬���������ֽ����ļ�
// 2. ����.class      ������ .java �ļ������ .java�ļ�����Ϊ .class�ļ������ڴ������Ҫ��ȡ class�ļ��������ַ���
// 3. ��Ķ���.getClass()   ���ڴ��� new һ���������ȡ�������� class �ļ����Ǿ������ַ���


// �� java ��
//  ��ȡ class������� Class
//  ��ȡ���췽������ Constructor
//  ��ȡ��Ա�������� Field
//  ��ȡ��Ա�������� Method

import java.io.EOFException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

class Student
{
    private String name;
    private int age;
    public String address;
    public Student(){};
    public Student(String name)
    {
        this.name = name;
    }
    protected Student(int age)
    {
        this.age = age;
    }
    private Student(String name,int age)
    {
        this.name = name;
        this.age = age;
    }
    public void setName(String name){
        this.name = name;
    }
    protected String getName()
    {
        return name;
    }
    public void setAge(int age) throws NumberFormatException,EnumConstantNotPresentException, EOFException
    {
        this.age = age;
    }
    private int getAge()
    {
        return age;
    }

    public String toString()
    {
        return "Student{name = " + name +",age = " + age +"}";
    }

}


public class Reflect
{
    public static void main(String[] args) throws Exception {
        System.out.println("-------��ȡclass�ļ�-------");
        // 1. Class.forName ��ȡ class �ļ������ַ�ʽ���
        // ȫ������ ���� + ����
        Class clazz = Class.forName("student.learn_java.Student");
        // ��ӡ
        System.out.println(clazz);

        // 2. .class��ʽ��������ǵ�������ȥ����
        Class clazz1 = Student.class;
        System.out.println(clazz1 == clazz);
        // �жϳ�������ʽ��ȡ����һ���ļ�

        // 3.����� class �ļ��� �������Ѿ��������Ķ����ǲſ���ȥʹ��
        Student st = new Student();
        Class clazz2 = st.getClass();
        System.out.println(clazz == clazz2);
        System.out.println(clazz1 == clazz2);
        // �жϳ����ַ�ʽ����ȡ����ͬһ�� class �ļ�
        System.out.println("--------��ȡ���췽��-------");
        // ��ȡ���췽��
        // Constructor<?>[] getConstructors() ��ȡ���� public ���εĹ��췽���������������,ͨ���Ϊ�����
        // Constructor<?>[] getDeclaredConstructors() ��ȡ���й��췽��������һ������ Declared ��Ȩ�޵���˼
        // Constructor<?> getConstructor(Class<?>...parameterTypes) ��ȡ public ���εĵ������캯������ķ���  parameter : ����
        // Constructor<?> getDeclaredConstructor(Class<?>...parameterTypes) ��ȡ�������캯������ķ���

        // 1.��ȡ class �ֽ����ļ�
        Class clazz3 = Class.forName("student.learn_java.Student");
        Constructor[] constructors = clazz3.getConstructors();
        System.out.println("--���� public ���췽��--");
        for(int i = 0; i < constructors.length; i++)
        {
            System.out.println(constructors[i]);
        }
        System.out.println("--���й��췽��--");
        Constructor[] declaredConstructors = clazz3.getDeclaredConstructors();
        for(int i = 0; i < declaredConstructors.length; i++)
        {
            System.out.println(declaredConstructors[i]);
        }
        System.out.println("--��ȡ����public���췽��--");
        // ����Ĳ���Ҫ�͹��캯���Ĳ�����ͬ��ʲô����д�൱���޲�
        System.out.println("--�޲�--");
        Constructor constructor = clazz3.getConstructor();
        System.out.println(constructor);
        System.out.println("--�в�--");
        // ��Ϊ getConstructor(Class<?>...parameterTypes) �� Class ���͵Ŀɱ��βΣ�����Ҫ����͹��췽����ͬ���͵��ֽ����ļ�
        Constructor constructor1 = clazz3.getConstructor(String.class);
        System.out.println(constructor1);
        System.out.println("-----��ȡ�������췽��-----");
        System.out.println("--�޲�--");
        Constructor declaredConstructor = clazz3.getDeclaredConstructor();
        System.out.println(declaredConstructor);
        System.out.println("--�в�--");
        Constructor declaredConstructor1 = clazz3.getDeclaredConstructor(String.class, int.class);
        System.out.println(declaredConstructor1);
        Constructor declaredConstructor2 = clazz3.getDeclaredConstructor(int.class);
        System.out.println(declaredConstructor2);
        System.out.println("---��ȡ�������---");
        System.out.println("--����--");
        int parameterCount = declaredConstructor1.getParameterCount();
        System.out.println(parameterCount);
        System.out.println("--��������--");
        Parameter[] parameters = declaredConstructor1.getParameters();
        for(Parameter parameter : parameters)
        {
            System.out.println(parameter);
        }
        System.out.println("----�÷������ɶ���----");
        // �������䣺��ʱȡ��Ȩ�޵�У�飬��������ʱ���� private ����
        declaredConstructor1.setAccessible(true);
        Student student = (Student) declaredConstructor1.newInstance("����", 18);     // instance ʵ��
        System.out.println(student);

        System.out.println("----------�÷����ȡ��Ա����-------");
        // �� ��ȡ���췽�����ƣ���ȡ��Ա�����ķ���
        // class ����
        // Field[] getFields()  ��ȡ public ��������
        // Field[] getDeclaredFields()  ��������
        // Field getField(String name) ���ص��� public ��Ա����
        // Field getDeclaredField(String name) ���ص�����Ա����

        // Field ���д�������ķ���
        // void set(Object obj, Object value)
        // void get(Object obj)

        // 1. ��ȡ�ֽ����ļ��Ķ���
        Class clazz4 = Class.forName("student.learn_java.Student");
        // 2. ��ȡ��Ա����
        System.out.println("------��ȡpublic��Ա����----");
        Field[] fields = clazz4.getFields();
        for(int i = 0;i < fields.length; i++)
            System.out.println(fields[i]);
        System.out.println("-------��ȡ���еĳ�Ա����------");
        Field[] declaredFields = clazz4.getDeclaredFields();
        for(int i = 0;i < declaredFields.length; i++)
            System.out.println(declaredFields[i]);
        System.out.println("-------��ȡ����public��Ա����------");
        Field field = clazz4.getField("address");   // �β�Ϊ ����������
        System.out.println(field);
        System.out.println("-----��ȡ������Ա����------");
        Field age = clazz4.getDeclaredField("age");
        System.out.println(age);
        System.out.println("-----��ȡ���η��������������ͣ���age����Ϊ����-----");
        int modifiers = age.getModifiers();
        String name = age.getName();
        Class type = age.getType();
        System.out.println(modifiers + " " + name + " " + type);  // 2 ��ʾ ���η�Ϊ private ����
        System.out.println("------��ȡ��Ա������¼��ֵ---------");
        age.setAccessible(true);
        Student s = new Student(20);
        Object value = age.get(s);
        System.out.println(value);
        System.out.println("------�÷����޸ĳ�Ա������¼��ֵ-----");
        age.set(s, 22);
        value = age.get(s);
        System.out.println(value);

        //��ȡ��Ա�����ķ���
        // Method[] getMethods();
        // Method[] getDeclaredMethods();
        // Method getMethod(String name,Class<?>...parameterTypes)
        // Method getDeclaredMethod(String name,Class<?>...parameterType)

        Class clazz5 = Class.forName("student.learn_java.Student");
        System.out.println("------public��Ա����(������������� public ����)------");
        Method[] methods = clazz5.getMethods();
        for(int i = 0; i < methods.length; i++)
            System.out.println(methods[i]);
        System.out.println("-------���г�Ա����(����������ķ���)------");
        Method[] declaredMethods = clazz5.getDeclaredMethods();
        for(int i = 0; i < declaredMethods.length; i++)
            System.out.println(declaredMethods[i]);
        System.out.println("-------��ȡ����public����-----");
        Method setAge = clazz5.getMethod("setAge", int.class);// ��һ������Ϊ���������֣��ڶ�������Ϊ�ɱ��βΣ�
                                                                    // ������Ƿ��������ͣ���ֹ����������
        System.out.println(setAge);
        System.out.println("--------��ȡ��������-------");
        Method getAge = clazz5.getDeclaredMethod("getAge");
        System.out.println(getAge);
        System.out.println("-------��ȡ���������η�(�� setAge ����Ϊ��)-------");
        int modifiers1 = setAge.getModifiers();
        System.out.println(modifiers1); // 1 ���� public
        System.out.println("-------��ȡ��������-------");
        String name1 = setAge.getName();
        System.out.println(name1);
        System.out.println("--------��ȡ�������β�-------");
        Parameter[] parameters1 = setAge.getParameters();
        for(int i = 0; i < parameters1.length; i++)
            System.out.println(parameters1[i]);
        System.out.println("--------��ȡ�����׳����쳣--------");
        Class[] exceptionTypes = setAge.getExceptionTypes();
        for(int i = 0; i < exceptionTypes.length; i++)
            System.out.println(exceptionTypes[i]);
        System.out.println("---------��������-----------");
        // ��������ķ���
        // Object invoke(Object obj, Object... args) :���з���
        // ����1���� obj������ø÷���
        // ����2�����÷����Ĳ�����û�оͲ�д��
        // ����ֵ�������ķ���ֵ
        Student s1 = new Student();
        // ����1 �� �����ĵ�����
        // ����2 �� ���÷���ʱ���õ�ʵ�ʲ���
        setAge.setAccessible(true);
        setAge.invoke(s1, 17);
        System.out.println(s1);
        System.out.println("--------��ȡ��������ֵ---------");
        getAge.setAccessible(true);
        Object invoke = getAge.invoke(s1);
        System.out.println(invoke);
    }
}
