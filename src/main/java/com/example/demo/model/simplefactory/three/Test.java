package com.example.demo.model.simplefactory.three;

public class Test {
    public static void main(String[] args) {
        VehicleFactory factory = VehicleFactory.getVehicleFactory();
        Movable movable = factory.createCar();
        movable.move();
        Movable movable1 = factory.createPlane();
        movable1.move();

    }
}
