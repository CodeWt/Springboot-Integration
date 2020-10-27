package com.example.demo.model.memento;

/**
 *  负责创建一个备忘录，用以记录当前时刻它的内部状态，并可以使用备忘录恢复内部状态。
 */
public class Originator {
    private String state_1;//需要保存的属性值，可能有多个

    public Memento createMemento(){
        return new Memento(state_1);
    }

    public void setMemento(Memento memento){
        state_1 = memento.getState_1();
    }

    public String getState_1() {
        return state_1;
    }

    public void setState_1(String state_1) {
        this.state_1 = state_1;
    }
}
