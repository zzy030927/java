package ExceptionDemo;

import java.util.Scanner;

class GirlFriend {
    String name;
    int age;

    @Override
    public String toString() {
        return "GirlFriend{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public GirlFriend() {
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age < 18)
            throw new RuntimeException("太小犯法");
        if (age > 29)
            throw new RuntimeException(".....");
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        int length = name.length();
        if (length < 3 || length > 10)
            throw new RuntimeException("姓名不对劲");
        this.name = name;
    }

    public GirlFriend(int age, String name) {
        this.age = age;
        this.name = name;
    }


}

public class Test {
    public static void main(String[] args) {
        Scanner src = new Scanner(System.in);
        GirlFriend girlFriend = new GirlFriend();
        do {
            try {
                System.out.println("名字: ");
                String name = src.nextLine();
                girlFriend.setName(name);
                System.out.println("年龄: ");
                String ageStr = src.nextLine();
                int age = Integer.parseInt(ageStr);
                girlFriend.setAge(age);
                break;
            } catch (NumberFormatException e) {
                System.err.println("你这是什么新格式的年龄？");
            } catch (RuntimeException e) {
                e.printStackTrace();
            }
        } while (true);
        System.out.println(girlFriend);
    }
}
