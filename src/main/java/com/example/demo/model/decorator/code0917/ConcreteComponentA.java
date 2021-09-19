package com.example.demo.model.decorator.code0917;

public class ConcreteComponentA extends Component{
    public ConcreteComponentA(String componetName) {
        super(componetName);
    }

    @Override
    protected void decorateM() {
        System.out.println("1. ConcreteComponentA 被装饰前的原始功能操作");
    }
}
