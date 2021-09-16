package com.example.demo.model.factory.code0915;

public class Test
{
    public static void main(String[] args) {
        BreadFactory breadFactory = BreadFactory.getBreadFactory();
        Food food = breadFactory.createFood();
        food.eat();

        ChickenFactory chickenFactory = ChickenFactory.getChickenFactory();
        Food food1 = chickenFactory.createFood();
        food1.eat();
    }
}
