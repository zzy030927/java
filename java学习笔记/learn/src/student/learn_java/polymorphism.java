package student.learn_java;
import java.lang.*;

//多态：同一个对象，不同时刻呈现出的多种状态，即同一个父类指向不同的子类
//访问变量时，引用父类的变量，当父类变量与子类变量相同时，还是引用父类对象，即 同一个对象
//当子类与父类有同一个方法时，引用子类的方法， 即 不同时刻呈现多种状态
class Animal {
    public int age = 40;
    public String name = "s";
    public void eat() {
        System.out.println("动物吃东西");
    }
    public void play() { System.out.println("动物玩游戏"); }
}
class Cat extends Animal {
    public int age = 20;
    public int weight = 10;

    public void eat() {
        System.out.println(super.age + " " + weight + "猫吃鱼");
    }

    public void playGame() {
        System.out.println("猫捉迷藏");
    }
}

public class polymorphism
{
    public static void main(String[] args) {
        Animal a = new Cat();   // 上转型

        System.out.println(a.age + a.name);
//        System.out.println(a.weight);

        System.out.println("-----多态包含上转型对象和下转型对象");
        System.out.println("-----上转型对象-------");
        System.out.println("-----父类指向子类-------");
        // 上转型对象 ：
        // 如果 A 是 B 的父类， 当用子类创建一个对象，并把这个对象的引用放到父类的对象中，如：
        Animal aim;
        Cat cat = new Cat();
        aim = cat;  // 上转型对象
        //   Animal aim = new Cat();
        System.out.println("Animal : " + aim.age + " " + aim.name);
        System.out.println("Cat : " + cat.age +" " + cat.weight);
        aim.eat();  // 在上转行对象中，父类可以调用子类中和自己方法中同名的方法
        aim.play();
        cat.eat();
        cat.playGame();
        cat.play();

        System.out.println("==========下转型----------");
        // 下转型，向下转, 相当于又转成一个自己的对象
        Animal animal = new Cat();
        Cat c;              // 下转型错误格式： Cat c = (Cat) new Animal();
        c = (Cat)animal;    // 下转型只能输写成这样的格式 ，相当于 Cat c = new Cat();
        System.out.println(c.age + "\t" + c.weight + "\t父类变量: " + c.name);
        c.eat();
        c.playGame();
        c.play();
    }
}