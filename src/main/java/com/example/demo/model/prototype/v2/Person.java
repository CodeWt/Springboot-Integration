package com.example.demo.model.prototype.v2;

/**
 *
 * 深克隆，引用类型也要实现Cloneable接口并实现clone方法
 *
 */
public class Person implements Cloneable{
    String name="lisi";
    int age=25;
    Location loc = new Location("bj",2203);

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Person p = (Person)super.clone();
        p.loc = (Location) loc.clone();
        return p;
    }
    @Override
    public String toString() {
        return "{\"name\":"+ name +",\"age\":"+ age + ",\"loc\":" + loc +"}";
    }
}
class Location implements Cloneable{
    /**
     *
     * String不需要深克隆
     *
     */
    String street;
    int roomNo;

    public Location(String street, int roomNo) {
        this.street = street;
        this.roomNo = roomNo;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return "{\"street\":"+ street +",\"roomNo\":"+ roomNo + "}";
    }
}