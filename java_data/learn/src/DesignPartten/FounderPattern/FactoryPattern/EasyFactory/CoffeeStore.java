package DesignPartten.FounderPattern.FactoryPattern.EasyFactory;

// CoffeeStore ”√¿¥ €¬Ùøß∑»
public class CoffeeStore {

    public void orderCoffee(String type){
        SimpleCoffeeFactory coffeeFactory = new SimpleCoffeeFactory();
        Coffee coffee = coffeeFactory.createCoffee(type);
        coffee.addSugar();
        coffee.addMilk();
    }
}
