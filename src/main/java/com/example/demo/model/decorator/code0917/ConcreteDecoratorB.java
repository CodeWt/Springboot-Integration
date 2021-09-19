package com.example.demo.model.decorator.code0917;

public class ConcreteDecoratorB extends Decorator{
    public ConcreteDecoratorB(String decoratorName) {
        super(decoratorName);
    }

    public ConcreteDecoratorB(String decoratorName, Component component) {
        super(decoratorName, component);
    }

    @Override
    protected void decorateM() {
        super.decorateM();
        System.out.println("具体装饰对象" + this.decoratorName + "装饰了" + super.componetName);
    }
}
