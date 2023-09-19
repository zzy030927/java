package DesignPartten.FounderPattern.FactoryPattern.EasyFactory;

// �򵥿��ȹ���: ���ڴ������ȶ���
public class SimpleCoffeeFactory {

    public Coffee createCoffee(String type){
        Coffee coffee = null;
        if("american".equalsIgnoreCase(type))
            coffee = new AmericanCoffee();
        else if("latte".equalsIgnoreCase(type))
            coffee = new LatteCoffee();
        else
            System.out.println("û�д˿���");
        return coffee;
    }
}
