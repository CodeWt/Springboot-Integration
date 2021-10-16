package com.example.demo.model.prototype.v4;

public class Person implements Cloneable{
    String name = "wt";
    int age = 25;
    Location loc = new Location(new StringBuilder("bj"),2004);

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Person p = (Person)super.clone();
        p.loc = (Location) loc.clone();
        return p;
    }

    public String toString() {
        return "{\"name\":"+ name +",\"age\":"+ age + ",\"loc\":" + loc +"}";
    }
}
class Location implements Cloneable{
    StringBuilder street;
    int roomNo;

    public Location(StringBuilder street, int roomNo) {
        this.street = street;
        this.roomNo = roomNo;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return "{\"street\":"+ street.toString() +",\"roomNo\":"+ roomNo + "}";
    }
}