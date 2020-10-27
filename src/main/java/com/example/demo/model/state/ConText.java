package com.example.demo.model.state;

/**
 *  维护一个 ConcreteState子类的实例，这个实例定义当前的状态
 */
public class ConText {
    private State state;
    //定义ConText的初始状态
    public ConText(State state){
        this.state = state;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
        System.out.println("当前的状态为 ： " + this.state.getClass().getName());
    }
    //对请求做处理，并设置下一状态
    public void request(){
        state.handle(this);
    }
}
