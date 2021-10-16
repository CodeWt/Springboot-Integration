package com.example.demo.model.prototype.v1;

/**
 *
 * 浅克隆，属性如果是引用类型则只拷贝引用
 *
 */
public class Person implements Cloneable{
    String name = "zhangsan";
    int age = 25;

    Location loc = new Location("bj",2202);
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return "{\"name\":"+ name +",\"age\":"+ age + ",\"loc\":" + loc +"}";
    }
}

class Location{
    String street;
    int roomNo;

    public Location(String street, int roomNo) {
        this.street = street;
        this.roomNo = roomNo;
    }

    @Override
    public String toString() {
        return "{\"street\":"+ street +",\"roomNo\":"+ roomNo + "}";
    }
}
