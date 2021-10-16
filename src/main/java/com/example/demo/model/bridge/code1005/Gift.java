package com.example.demo.model.bridge.code1005;

public abstract class Gift {
    protected GiftImpl gift;
    public Gift(GiftImpl gift){
        this.gift = gift;
    }
    public Gift(){}

    abstract void disGiftName();
}
