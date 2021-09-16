package com.example.demo.model.composite;

/**
 *  组合中的对象声明接口，在适当的情况下，实现所有类共有接口的默认行为。声明一个接口用于访问和管理Component的子部件。
 */
public abstract class Component {
    protected String name;

    public Component(String name){
        this.name = name;
    }
    //通常都用Add 和 Remove 方法来提供增加或移除树叶或树枝的功能
    public abstract void add(Component component);
    public abstract void remove(Component component);
    public abstract void display(int depth);
}