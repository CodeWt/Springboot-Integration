package com.example.demo.model.bridge;

/**
 *  抽象
 */
public class Abstraction {
    protected Implementor implementor;
    public void setImplementor(Implementor implementor){
        this.implementor = implementor;
    }

    public void operation(){
        implementor.operation();
    }
}

