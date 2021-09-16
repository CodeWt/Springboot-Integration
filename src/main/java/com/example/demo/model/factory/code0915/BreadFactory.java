package com.example.demo.model.factory.code0915;

public class BreadFactory extends FoodFactory {
    @Override
    Food createFood() {
        return new Bread();
    }

    public static final BreadFactory INSTANCE;
    static {
        INSTANCE = new BreadFactory();
    }

    private BreadFactory(){}
    public static BreadFactory getBreadFactory(){
        return INSTANCE;
    }
}
