package com.example.demo.model.bridge.code1005;

public class Test {
    public static void main(String[] args) {
        Gift g1 = new WarmGift(new Book("《白夜行》"));
        g1.disGiftName();
        Gift g2 = new WildGift(new FLower("罂粟花"));
        g2.disGiftName();
    }
}
