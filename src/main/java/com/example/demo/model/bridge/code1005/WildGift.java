package com.example.demo.model.bridge.code1005;

public class WildGift extends Gift {
    public WildGift(GiftImpl gift) {
        super(gift);
    }

    @Override
    void disGiftName() {
        System.out.println(this.getClass().getSimpleName() + "-" + this.gift.giftName);
    }
}
