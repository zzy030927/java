package IO;

import java.io.Serial;
import java.io.Serializable;


// Serializable 接口里面没有抽象方法，所有这种接口通常被称为 标记接口
// 一旦类实现了这个接口，那么表示这个类可以被序列化
public class Student implements Serializable {

    private static final long serialVersionUID = -1619456459232783496L; // 声明版本号的作用, 变量名固定
    // 如果不声明，那么修改 Student 类时，那么版本号会发生变化，如果序列化时读取到的版本号是 1，修改后的版本号就为 2，那么 反序列化时版本号不相同会报错
    private String name;
    private int age;

    // transient 关键字作用：不会把这个变量序列化到本地文件当中
    private transient String address;

    public Student(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                '}';
    }
}
