package ExceptionDemo;

import java.util.Scanner;

// �Զ����쳣���裺�� �쳣��Ҫ���׶� �� �̳���Ӧ���࣬������Ҫ����ʲô�쳣 �� �ղι��� �� �вι���

// ������ʽ�쳣
class NameFormatException extends RuntimeException {
    public NameFormatException () {}

    public NameFormatException (String msg) {
        super(msg);
    }
}

// ���䳬����Χ�쳣
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
            throw new AgeOutOfBoundException("̫С����");
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
            throw new NameFormatException("�������Ծ�");
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
                System.out.println("����: ");
                String name = src.nextLine();
                girlfriend.setName(name);
                System.out.println("����: ");
                String ageStr = src.nextLine();
                int age = Integer.parseInt(ageStr);
                girlfriend.setAge(age);
                break;
            } catch (NumberFormatException e) {
                System.err.println("������ʲô�¸�ʽ�����䣿");
            } catch (AgeOutOfBoundException e) {
                e.printStackTrace();
            } catch (NameFormatException e) {
                e.printStackTrace();
            }
        } while (true);
        System.out.println(girlfriend);
    }
}

