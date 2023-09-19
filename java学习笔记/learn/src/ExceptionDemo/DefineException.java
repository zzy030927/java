package ExceptionDemo;

import java.util.Scanner;

// 自定义异常步骤：① 异常名要简单易懂 ② 继承相应的类，看具体要定义什么异常 ③ 空参构造 ④ 有参构造

// 姓名格式异常
class NameFormatException extends RuntimeException {
    public NameFormatException () {}

    public NameFormatException (String msg) {
        super(msg);
    }
}

// 年龄超出范围异常
class AgeOutOfBoundException extends RuntimeException {
    public AgeOutOfBoundException() {
    }

    public AgeOutOfBoundException(String message) {
        super(message);
    }
}

class Girl {
    String name;
    int age;

    @Override
    public String toString() {
        return "Girl{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public Girl() {
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age < 18)
            throw new AgeOutOfBoundException("太小犯法");
        if (age > 29)
            throw new AgeOutOfBoundException(".....");
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        int length = name.length();
        if (length < 3 || length > 10)
            throw new NameFormatException("姓名不对劲");
        this.name = name;
    }

    public Girl(int age, String name) {
        this.age = age;
        this.name = name;
    }


}

public class DefineException {
    public static void main(String[] args) {
        Scanner src = new Scanner(System.in);
        Girl girlfriend = new Girl();
        do {
            try {
                System.out.println("名字: ");
                String name = src.nextLine();
                girlfriend.setName(name);
                System.out.println("年龄: ");
                String ageStr = src.nextLine();
                int age = Integer.parseInt(ageStr);
                girlfriend.setAge(age);
                break;
            } catch (NumberFormatException e) {
                System.err.println("你这是什么新格式的年龄？");
            } catch (AgeOutOfBoundException e) {
                e.printStackTrace();
            } catch (NameFormatException e) {
                e.printStackTrace();
            }
        } while (true);
        System.out.println(girlfriend);
    }
}

