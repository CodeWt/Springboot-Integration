package com.example.demo.model.proxy.one;

public class OneTest {
    public static void main(String[] args) {
        SchoolGirl girl = new SchoolGirl();
        girl.setName("Pretty girl , ");
        Proxy proxy =  new Proxy(girl);
        proxy.giveDolls();
        proxy.giveFlowers();
        proxy.giveChocolate();
    }
}
