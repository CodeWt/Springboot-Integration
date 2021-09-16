package com.example.demo.model.decorator.one;

public class ClientOneTest {
    public static void main(String[] args) {
        //被装饰的具体对象
        ConcreteComponent concreteComponent = new ConcreteComponent();
        //具体装饰对象A、B
        ConcreteDecoratorA concreteDecoratorA = new ConcreteDecoratorA();
        ConcreteDecoratorB concreteDecoratorB = new ConcreteDecoratorB();

        concreteDecoratorA.setComponent(concreteComponent);
        concreteDecoratorB.setComponent(concreteDecoratorA);
        concreteDecoratorB.operation();
    }
}
