package com.example.demo.model.memento;

/**
 *  管理者类
 *  负责保存好备忘录Memento
 */
public class Caretaker {
    //被管理的备忘录
    private Memento memento;

    public Memento getMemento() {
        return memento;
    }

    public void setMemento(Memento memento) {
        this.memento = memento;
    }
}
