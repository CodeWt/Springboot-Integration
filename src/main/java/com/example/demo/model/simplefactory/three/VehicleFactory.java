package com.example.demo.model.simplefactory.three;

public class VehicleFactory {

    private static final VehicleFactory VehicleFactory= new VehicleFactory();
    private VehicleFactory(){}
    public static VehicleFactory getVehicleFactory(){
        return VehicleFactory;
    }

    Movable createCar(){
        //控制生产过程。。
        return new Car();
    }
    Movable createPlane(){
        return new Plane();
    }
}
