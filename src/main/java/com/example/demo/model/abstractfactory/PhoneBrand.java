package com.example.demo.model.abstractfactory;

public abstract class PhoneBrand {

    protected String name;
    public PhoneBrand(String name){
        this.name = name;
    }
    abstract void communicate();

}
