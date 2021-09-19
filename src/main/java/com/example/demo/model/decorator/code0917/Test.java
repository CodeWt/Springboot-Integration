package com.example.demo.model.decorator.code0917;

public class Test {
    public static void main(String[] args) {
        Component component = new ConcreteComponentA("被装饰的组件对象A");
        Decorator concreteDecoratorA = new ConcreteDecoratorA("具体装饰对象A", component);
        Decorator concreteDecoratorB = new ConcreteDecoratorB("具体装饰对象B", concreteDecoratorA);
        concreteDecoratorB.decorateM();

    }
}
