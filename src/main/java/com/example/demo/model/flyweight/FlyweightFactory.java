package com.example.demo.model.flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 *  FlyweightFactory 是一个共享工厂，用来创建并管理Flyweight对象。它主要是用来确保合理地共享Flyweight，当用户请求一个Flyweight时，
 *  FlyweightFactory 对象提供一个已创建的实例或者创建一个。
 */
public class FlyweightFactory {
    private Map map = new HashMap();
    public FlyweightFactory(){
        //初始化工厂时，先生成三个实例
        map.put("X",new ConcreteFlyweight());
        map.put("Y",new ConcreteFlyweight());
        map.put("Z",new ConcreteFlyweight());
    }
    public Flyweight getFlyWeight(String key){
        //根据客户端的请求，获得已生成的实例
        return (Flyweight)map.get(key);
    }
}
