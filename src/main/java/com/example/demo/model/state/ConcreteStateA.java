package com.example.demo.model.state;

/**
 *  ConcreteState类，具体状态，每一个子类实现一个与Context的一个状态相关的行为
 */
public class ConcreteStateA extends State {
    @Override
    public void handle(ConText context) {
        //设置ConcreteStateA 的下一状态是ConcreteStateB
        context.setState(new ConcreteStateB());
    }
}
