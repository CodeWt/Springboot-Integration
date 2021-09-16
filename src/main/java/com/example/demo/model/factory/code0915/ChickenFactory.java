package com.example.demo.model.factory.code0915;

public class ChickenFactory extends FoodFactory{

    private static final class InstanceHolder{
        private static final ChickenFactory INSTANCE=new ChickenFactory();
    }
    private ChickenFactory(){}
    public static ChickenFactory getChickenFactory(){
        return InstanceHolder.INSTANCE;
    }

    @Override
    Food createFood() {
        return new Chicken();
    }
}
