package ExceptionDemo;

class Student {
    int age;
    public Student (int age) {
        if (age < 18 || age > 26) {
            throw new RuntimeException(age + "不能接受");
        } else {
            System.out.println(age + "可以接受");
            this.age = age;
        }
    }
}

// 异常的两个作用：
// 1. 异常是用来查看 bug 的关键参考信息
// 2. 异常可以作为方法内部的一种特殊返回值，以便通知底层的执行情况
public class ReturnException {
    public static void main(String[] args) {
        Student student = new Student(18);
        Student student1 = new Student(50);
    }
}
