package com.example.demo.model.abstractfactory;

public class HUAWEI extends PhoneBrand{
    public HUAWEI(String name) {
        super(name);
    }

    @Override
    void communicate() {
        System.out.println("I use " + this.name + " to say with you ! ");
    }
}
