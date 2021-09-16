package com.example.demo.model.abstractfactory;

public class Test {
    public static void main(String[] args) {
        ChinaFactory chinaFactory = ChinaFactory.getFactory();
        ClothesBrand clothesBrand = chinaFactory.createClothesBrand();
        clothesBrand.putClothes();
        PhoneBrand phoneBrand = chinaFactory.createPhoneBrand();
        phoneBrand.communicate();
        System.out.println("------------------");
        AmericaFactory americaFactory = AmericaFactory.getFactory();
        ClothesBrand clothesBrand1 = americaFactory.createClothesBrand();
        clothesBrand1.putClothes();
        PhoneBrand phoneBrand1 = americaFactory.createPhoneBrand();
        phoneBrand1.communicate();
    }
}
