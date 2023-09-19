package student.learn_java;

// 反射 ：Reflection（反射），它允许运行中的 java 程序对自身进行检查，被 private 封装的资源只能被类内部访问，外部是不行的
// 但是反射能直接操作类内部私有属性，反射可以在运行时获取一个类的信息，（包括成员变量，成员方法，构造器等）
// 想要解剖一个类，必须先获取到该类的字节码文件对象。而解剖使用的就是 Class类中的方法。所以要先获取到每一个字节码文件对象的 Class类型的对象

// 反射就是把 java类中的各种成分映射成一个个的 java 对象。
// 比如：idea的自动提示功能就是用 反射实现的，还有提示一个方法形参也是通过反射 ctrl+p
// 反射就是从类里面拿东西，可以获取类所有的信息，包括名字、类型、修饰符、形参、抛出的异常等等

// 获取 class 文件的三种方法:
// 1. Class.forName("全类名");     Class 类，用来描述字节码文件
// 2. 类名.class      在生成 .java 文件且这个 .java文件编译为 .class文件放入内存后，我们要获取 class文件就用这种方法
// 3. 类的对象.getClass()   在内存中 new 一个对象，想获取这个对象的 class 文件我们就用这种方法


// 在 java 中
//  获取 class对象的类 Class
//  获取构造方法的类 Constructor
//  获取成员变量的类 Field
//  获取成员方法的类 Method

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
        System.out.println("-------获取class文件-------");
        // 1. Class.forName 获取 class 文件，这种方式最常用
        // 全类名： 包名 + 类名
        Class clazz = Class.forName("student.learn_java.Student");
        // 打印
        System.out.println(clazz);

        // 2. .class方式，更多的是当作参数去传递
        Class clazz1 = Student.class;
        System.out.println(clazz1 == clazz);
        // 判断出两个方式获取的是一个文件

        // 3.对象的 class 文件， 当我们已经有这个类的对象是才可以去使用
        Student st = new Student();
        Class clazz2 = st.getClass();
        System.out.println(clazz == clazz2);
        System.out.println(clazz1 == clazz2);
        // 判断出三种方式都获取的是同一个 class 文件
        System.out.println("--------获取构造方法-------");
        // 获取构造方法
        // Constructor<?>[] getConstructors() 获取所有 public 修饰的构造方法，返回这个数组,通配符为这个类
        // Constructor<?>[] getDeclaredConstructors() 获取所有构造方法，返回一个数组 Declared ：权限的意思
        // Constructor<?> getConstructor(Class<?>...parameterTypes) 获取 public 修饰的单个构造函数对象的方法  parameter : 参数
        // Constructor<?> getDeclaredConstructor(Class<?>...parameterTypes) 获取单个构造函数对象的方法

        // 1.获取 class 字节码文件
        Class clazz3 = Class.forName("student.learn_java.Student");
        Constructor[] constructors = clazz3.getConstructors();
        System.out.println("--所有 public 构造方法--");
        for(int i = 0; i < constructors.length; i++)
        {
            System.out.println(constructors[i]);
        }
        System.out.println("--所有构造方法--");
        Constructor[] declaredConstructors = clazz3.getDeclaredConstructors();
        for(int i = 0; i < declaredConstructors.length; i++)
        {
            System.out.println(declaredConstructors[i]);
        }
        System.out.println("--获取单个public构造方法--");
        // 传入的参数要和构造函数的参数相同，什么都不写相当与无参
        System.out.println("--无参--");
        Constructor constructor = clazz3.getConstructor();
        System.out.println(constructor);
        System.out.println("--有参--");
        // 因为 getConstructor(Class<?>...parameterTypes) 是 Class 类型的可变形参，所以要传入和构造方法相同类型的字节码文件
        Constructor constructor1 = clazz3.getConstructor(String.class);
        System.out.println(constructor1);
        System.out.println("-----获取单个构造方法-----");
        System.out.println("--无参--");
        Constructor declaredConstructor = clazz3.getDeclaredConstructor();
        System.out.println(declaredConstructor);
        System.out.println("--有参--");
        Constructor declaredConstructor1 = clazz3.getDeclaredConstructor(String.class, int.class);
        System.out.println(declaredConstructor1);
        Constructor declaredConstructor2 = clazz3.getDeclaredConstructor(int.class);
        System.out.println(declaredConstructor2);
        System.out.println("---获取具体参数---");
        System.out.println("--个数--");
        int parameterCount = declaredConstructor1.getParameterCount();
        System.out.println(parameterCount);
        System.out.println("--具体类型--");
        Parameter[] parameters = declaredConstructor1.getParameters();
        for(Parameter parameter : parameters)
        {
            System.out.println(parameter);
        }
        System.out.println("----用反射生成对象----");
        // 暴力反射：临时取消权限的校验，即可以临时访问 private 对象
        declaredConstructor1.setAccessible(true);
        Student student = (Student) declaredConstructor1.newInstance("张三", 18);     // instance 实例
        System.out.println(student);

        System.out.println("----------用反射获取成员变量-------");
        // 和 获取构造方法类似，获取成员变量的方法
        // class 类中
        // Field[] getFields()  获取 public 变量数组
        // Field[] getDeclaredFields()  变量数组
        // Field getField(String name) 返回单个 public 成员变量
        // Field getDeclaredField(String name) 返回单个成员变量

        // Field 类中创建对象的方法
        // void set(Object obj, Object value)
        // void get(Object obj)

        // 1. 获取字节码文件的对象
        Class clazz4 = Class.forName("student.learn_java.Student");
        // 2. 获取成员变量
        System.out.println("------获取public成员变量----");
        Field[] fields = clazz4.getFields();
        for(int i = 0;i < fields.length; i++)
            System.out.println(fields[i]);
        System.out.println("-------获取所有的成员变量------");
        Field[] declaredFields = clazz4.getDeclaredFields();
        for(int i = 0;i < declaredFields.length; i++)
            System.out.println(declaredFields[i]);
        System.out.println("-------获取单个public成员变量------");
        Field field = clazz4.getField("address");   // 形参为 变量的名字
        System.out.println(field);
        System.out.println("-----获取单个成员变量------");
        Field age = clazz4.getDeclaredField("age");
        System.out.println(age);
        System.out.println("-----获取修饰符、变量名、类型（以age变量为例）-----");
        int modifiers = age.getModifiers();
        String name = age.getName();
        Class type = age.getType();
        System.out.println(modifiers + " " + name + " " + type);  // 2 表示 修饰符为 private 类型
        System.out.println("------获取成员变量记录的值---------");
        age.setAccessible(true);
        Student s = new Student(20);
        Object value = age.get(s);
        System.out.println(value);
        System.out.println("------用反射修改成员变量记录的值-----");
        age.set(s, 22);
        value = age.get(s);
        System.out.println(value);

        //获取成员方法的方法
        // Method[] getMethods();
        // Method[] getDeclaredMethods();
        // Method getMethod(String name,Class<?>...parameterTypes)
        // Method getDeclaredMethod(String name,Class<?>...parameterType)

        Class clazz5 = Class.forName("student.learn_java.Student");
        System.out.println("------public成员方法(包含父类的所有 public 方法)------");
        Method[] methods = clazz5.getMethods();
        for(int i = 0; i < methods.length; i++)
            System.out.println(methods[i]);
        System.out.println("-------所有成员方法(不包含父类的方法)------");
        Method[] declaredMethods = clazz5.getDeclaredMethods();
        for(int i = 0; i < declaredMethods.length; i++)
            System.out.println(declaredMethods[i]);
        System.out.println("-------获取单个public方法-----");
        Method setAge = clazz5.getMethod("setAge", int.class);// 第一个参数为方法的名字，第二个参数为可变形参，
                                                                    // 传入的是方法的类型，防止方法的重载
        System.out.println(setAge);
        System.out.println("--------获取单个方法-------");
        Method getAge = clazz5.getDeclaredMethod("getAge");
        System.out.println(getAge);
        System.out.println("-------获取方法的修饰符(以 setAge 方法为例)-------");
        int modifiers1 = setAge.getModifiers();
        System.out.println(modifiers1); // 1 代表 public
        System.out.println("-------获取方法名字-------");
        String name1 = setAge.getName();
        System.out.println(name1);
        System.out.println("--------获取方法的形参-------");
        Parameter[] parameters1 = setAge.getParameters();
        for(int i = 0; i < parameters1.length; i++)
            System.out.println(parameters1[i]);
        System.out.println("--------获取方法抛出的异常--------");
        Class[] exceptionTypes = setAge.getExceptionTypes();
        for(int i = 0; i < exceptionTypes.length; i++)
            System.out.println(exceptionTypes[i]);
        System.out.println("---------方法运行-----------");
        // 创建对象的方法
        // Object invoke(Object obj, Object... args) :运行方法
        // 参数1：用 obj对象调用该方法
        // 参数2：调用方法的参数（没有就不写）
        // 返回值：方法的返回值
        Student s1 = new Student();
        // 参数1 ： 方法的调用者
        // 参数2 ： 调用方法时调用的实际参数
        setAge.setAccessible(true);
        setAge.invoke(s1, 17);
        System.out.println(s1);
        System.out.println("--------获取方法返回值---------");
        getAge.setAccessible(true);
        Object invoke = getAge.invoke(s1);
        System.out.println(invoke);
    }
}
