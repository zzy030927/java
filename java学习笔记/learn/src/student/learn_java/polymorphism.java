package student.learn_java;
import java.lang.*;

//��̬��ͬһ�����󣬲�ͬʱ�̳��ֳ��Ķ���״̬����ͬһ������ָ��ͬ������
//���ʱ���ʱ�����ø���ı�������������������������ͬʱ���������ø�����󣬼� ͬһ������
//�������븸����ͬһ������ʱ����������ķ����� �� ��ͬʱ�̳��ֶ���״̬
class Animal {
    public int age = 40;
    public String name = "s";
    public void eat() {
        System.out.println("����Զ���");
    }
    public void play() { System.out.println("��������Ϸ"); }
}
class Cat extends Animal {
    public int age = 20;
    public int weight = 10;

    public void eat() {
        System.out.println(super.age + " " + weight + "è����");
    }

    public void playGame() {
        System.out.println("è׽�Բ�");
    }
}

public class polymorphism
{
    public static void main(String[] args) {
        Animal a = new Cat();   // ��ת��

        System.out.println(a.age + a.name);
//        System.out.println(a.weight);

        System.out.println("-----��̬������ת�Ͷ������ת�Ͷ���");
        System.out.println("-----��ת�Ͷ���-------");
        System.out.println("-----����ָ������-------");
        // ��ת�Ͷ��� ��
        // ��� A �� B �ĸ��࣬ �������ഴ��һ�����󣬲��������������÷ŵ�����Ķ����У��磺
        Animal aim;
        Cat cat = new Cat();
        aim = cat;  // ��ת�Ͷ���
        //   Animal aim = new Cat();
        System.out.println("Animal : " + aim.age + " " + aim.name);
        System.out.println("Cat : " + cat.age +" " + cat.weight);
        aim.eat();  // ����ת�ж����У�������Ե��������к��Լ�������ͬ���ķ���
        aim.play();
        cat.eat();
        cat.playGame();
        cat.play();

        System.out.println("==========��ת��----------");
        // ��ת�ͣ�����ת, �൱����ת��һ���Լ��Ķ���
        Animal animal = new Cat();
        Cat c;              // ��ת�ʹ����ʽ�� Cat c = (Cat) new Animal();
        c = (Cat)animal;    // ��ת��ֻ����д�������ĸ�ʽ ���൱�� Cat c = new Cat();
        System.out.println(c.age + "\t" + c.weight + "\t�������: " + c.name);
        c.eat();
        c.playGame();
        c.play();
    }
}