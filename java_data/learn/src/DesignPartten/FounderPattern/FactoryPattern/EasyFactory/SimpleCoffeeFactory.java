package DesignPartten.FounderPattern.FactoryPattern.EasyFactory;

// 简单咖啡工厂: 用于创建咖啡对象
public class SimpleCoffeeFactory {

    public Coffee createCoffee(String type){
        Coffee coffee = null;
        if("american".equalsIgnoreCase(type))
            coffee = new AmericanCoffee();
        else if("latte".equalsIgnoreCase(type))
            coffee = new LatteCoffee();
        else
            System.out.println("没有此咖啡");
        return coffee;
    }
}
