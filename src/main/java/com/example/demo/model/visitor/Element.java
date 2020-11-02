package com.example.demo.model.visitor;

/**
 *  定义一个accept操作，他以一个访问者为参数
 */
public abstract class Element {
    public abstract void accept(Visitor visitor);
}
