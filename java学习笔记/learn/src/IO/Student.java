package IO;

import java.io.Serial;
import java.io.Serializable;


// Serializable �ӿ�����û�г��󷽷����������ֽӿ�ͨ������Ϊ ��ǽӿ�
// һ����ʵ��������ӿڣ���ô��ʾ�������Ա����л�
public class Student implements Serializable {

    private static final long serialVersionUID = -1619456459232783496L; // �����汾�ŵ�����, �������̶�
    // �������������ô�޸� Student ��ʱ����ô�汾�Żᷢ���仯��������л�ʱ��ȡ���İ汾���� 1���޸ĺ�İ汾�ž�Ϊ 2����ô �����л�ʱ�汾�Ų���ͬ�ᱨ��
    private String name;
    private int age;

    // transient �ؼ������ã����������������л��������ļ�����
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
