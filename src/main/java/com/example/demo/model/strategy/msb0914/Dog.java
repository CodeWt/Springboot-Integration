package com.example.demo.model.strategy.msb0914;

public class Dog implements Comparable<Dog> {

    public Dog(int food) {
        this.food = food;
    }

    public int food;

    @Override
    public int compareTo(Dog dog) {
        if (this.food < dog.food) return -1;
        else if (this.food> dog.food) return 1;
        else return 0;
    }
    @Override
    public String toString(){
        return "Dog{"+ this.food + "}";
    }
}
