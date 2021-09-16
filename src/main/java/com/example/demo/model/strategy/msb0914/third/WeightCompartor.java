package com.example.demo.model.strategy.msb0914.third;

import com.example.demo.model.strategy.msb0914.Cat;

public class WeightCompartor implements Compartor<Cat>{

    @Override
    public int compareTo(Cat o1, Cat o2) {
        if (o1.getWeight()<o2.getWeight()) return -1;
        else if (o1.getWeight() > o2.getWeight()) return 1;
        else return 0;
    }
}
