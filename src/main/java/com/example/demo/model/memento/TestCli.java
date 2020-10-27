package com.example.demo.model.memento;

public class TestCli {
    public static void main(String[] args) {
        Originator originator = new Originator();
        originator.setState_1("On");// Originator初始状态，状态属性为"On"
        System.out.println(originator.getState_1());

        Caretaker caretaker = new Caretaker();
        caretaker.setMemento(originator.createMemento());

        originator.setState_1("Off");
        System.out.println(originator.getState_1());

        originator.setMemento(caretaker.getMemento());
        System.out.println(originator.getState_1());
    }
}
