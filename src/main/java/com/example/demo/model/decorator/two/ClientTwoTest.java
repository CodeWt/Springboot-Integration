package com.example.demo.model.decorator.two;

public class ClientTwoTest {
    public static void main(String[] args) {
        Person person = new Person("小菜");
        System.out.println("第一种装扮： ");
        Sneakers sneakers = new Sneakers();
        BigTrouser trouser = new BigTrouser();
        Tshirts tshirts = new Tshirts();
        sneakers.decorate(person);
        trouser.decorate(sneakers);
        tshirts.decorate(trouser);
        tshirts.show();
    }
}
