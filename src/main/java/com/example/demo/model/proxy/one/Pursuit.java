package com.example.demo.model.proxy.one;

public class Pursuit implements IGiveGift {

    SchoolGirl girl;

    public Pursuit(SchoolGirl girl){
        this.girl = girl;
    }
    @Override
    public void giveDolls() {
        System.out.println(this.girl.getName() + "送你洋娃娃 。");
    }

    @Override
    public void giveFlowers() {
        System.out.println(this.girl.getName() + "送你鲜花 。");
    }

    @Override
    public void giveChocolate() {
        System.out.println(this.girl.getName() + "送你巧克力 。");
    }
}
