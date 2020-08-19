package com.example.demo.model.decorator.one;

/**
 * ConcreteDecoratorA 是具体的装饰对象，
 * 起到给Component添加职责的功能。
 */
public class ConcreteDecoratorA extends Decorator {
    //本类独有的功能，以区别于ConcreteDecoratorB
    private String addedState;

    @Override
    public void operation() {
        super.operation();//首先运行原有的Component的operation(),
        addedState = "New State";//在执行本类的功能，如 addedState,相当于对原有的Component进行了装饰
        System.out.println("具体装饰对象A的操作。");
    }
}
