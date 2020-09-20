package com.example.demo.model.observe;

import java.util.ArrayList;
import java.util.List;

/**
 *  Subject 类，它把所有的观察者对象的引用保存在一个聚集里，每个主题都可以有任何数量的观察者。
 *  抽象主题提供一个接口，可以add delete观察者对象
 */
public abstract class Subject {

    private List<Observer> observers = new ArrayList<>();

    public void attach(Observer observer){
        observers.add(observer);
    }

    public void detach(Observer observer){
        observers.remove(observer);
    }

    public void inform(){
        for (Observer o :
                observers) {
            o.updateState();
        }
    }

}
