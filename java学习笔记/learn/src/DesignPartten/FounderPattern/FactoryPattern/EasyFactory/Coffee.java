package DesignPartten.FounderPattern.FactoryPattern.EasyFactory;

public class Coffee {

    private String coffeeName;
    protected void setName(String name){
        this.coffeeName = name;
    };

    public void addSugar(){
        System.out.println(coffeeName + "╪слг");
    }

    public void addMilk(){
        System.out.println(coffeeName + "╪сдл");
    }
}
