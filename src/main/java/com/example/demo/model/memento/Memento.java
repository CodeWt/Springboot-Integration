package com.example.demo.model.memento;

/**
 *  负责存储Originator对象的内部状态，并可以防止Originator之外的其它对象访问备忘录Memento
 */
public class Memento {

    private String state_1;

    public Memento(String state_1) {

        this.state_1 = state_1;
    }

    public String getState_1() {
        return state_1;
    }

    public void setState_1(String state_1) {
        this.state_1 = state_1;
    }
}
