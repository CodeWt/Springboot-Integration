package com.example.demo.model.bridge.code1005;

public class WarmGift extends Gift{
    public WarmGift(GiftImpl gift) {
        super(gift);
    }
    public WarmGift(){

    }
    @Override
    void disGiftName() {
        System.out.println(this.getClass().getSimpleName() + "-" + this.gift.giftName);
    }
}
