package com.example.demo.model.decorator.code0917;

public abstract class Component {
    protected String componetName;
    public Component(){}
    public Component(String componetName) {
        this.componetName = componetName;
    }

    protected abstract void decorateM();
}
