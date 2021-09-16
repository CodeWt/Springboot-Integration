package com.example.demo.model.abstractfactory;

public class ChinaFactory extends AbstractFactory{

    @Override
    public ClothesBrand createClothesBrand() {
        return new NOONE();
    }

    @Override
    public PhoneBrand createPhoneBrand() {
        return new HUAWEI("HUAWEI P9");
    }


    private static final ChinaFactory INSTANCE = new ChinaFactory();
    private ChinaFactory(){

    }

    public static ChinaFactory getFactory(){
        return INSTANCE;
    }

}
