package ExceptionDemo;

class Student {
    int age;
    public Student (int age) {
        if (age < 18 || age > 26) {
            throw new RuntimeException(age + "���ܽ���");
        } else {
            System.out.println(age + "���Խ���");
            this.age = age;
        }
    }
}

// �쳣���������ã�
// 1. �쳣�������鿴 bug �Ĺؼ��ο���Ϣ
// 2. �쳣������Ϊ�����ڲ���һ�����ⷵ��ֵ���Ա�֪ͨ�ײ��ִ�����
public class ReturnException {
    public static void main(String[] args) {
        Student student = new Student(18);
        Student student1 = new Student(50);
    }
}
