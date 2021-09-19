package com.example.demo.model.decorator.code0917;

public class ConcreteDecoratorA extends Decorator{
    public ConcreteDecoratorA(String decoratorName) {
        super(decoratorName);
    }

    public ConcreteDecoratorA(String decoratorName, Component component) {
        super(decoratorName, component);
    }

    @Override
    protected void decorateM() {
        super.decorateM();
        System.out.println("具体装饰器"+ this.decoratorName+ "装饰了" + this.component.componetName);
    }
}
