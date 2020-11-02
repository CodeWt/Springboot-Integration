package com.example.demo.model.visitor;

public class ConcreteElementY extends Element {
    @Override
    public void accept(Visitor visitor) {
        visitor.visitConcreteElementY(this);
    }
    public void operateY(){

    }
}
