package com.example.demo.model.visitor;

/**
 *  具体元素，实现accept操作
 */
public class ConcreteElementX extends Element {
    @Override
    public void accept(Visitor visitor) {
        //双分派技术，实现处理与数据结构的分离
        visitor.visitConcreteElementX(this);
    }
    //其它相关的方法
    public void operateX(){

    }
}
