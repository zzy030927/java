package DesignPartten.FounderPattern.FactoryPattern.EasyFactory;

public class Customer {
    public static void main(String[] args) {
        CoffeeStore customer = new CoffeeStore();
        customer.orderCoffee("latte");
        System.out.println("---------");
        customer.orderCoffee("american");
        System.out.println("---------");
        customer.orderCoffee("queChao");
    }
}
