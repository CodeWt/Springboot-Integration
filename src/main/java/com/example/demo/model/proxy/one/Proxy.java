package com.example.demo.model.proxy.one;

public class Proxy implements IGiveGift {
    Pursuit pursuit ;
    public Proxy(SchoolGirl girl){
        pursuit = new Pursuit(girl);
    }
    @Override
    public void giveDolls() {
        pursuit.giveDolls();
    }

    @Override
    public void giveFlowers() {
        pursuit.giveFlowers();
    }

    @Override
    public void giveChocolate() {
        pursuit.giveChocolate();
    }
}
