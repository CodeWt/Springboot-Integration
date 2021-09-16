package com.example.demo.model.strategy.msb0914;

public class Cat implements Comparable<Cat> {
    private int weight;
    private int height;

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Cat(int weight, int height) {
        this.weight = weight;
        this.height = height;
    }

    @Override
    public String toString() {
        return "Cat{weight:" + this.weight + ",height:" + this.height + "}";
    }

    @Override
    public int compareTo(Cat cat) {
        if(this.weight< cat.getWeight()) return -1;
        else if (this.weight > cat.getWeight()) return 1;
        else return 0;
    }
}
