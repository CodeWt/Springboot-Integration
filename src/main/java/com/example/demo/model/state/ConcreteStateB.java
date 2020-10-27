package com.example.demo.model.state;

public class ConcreteStateB extends State{
    @Override
    public void handle(ConText context) {
        //设置ConcreteStateB的下一状态是ConcreteStateA
        context.setState(new ConcreteStateA());
    }
}
