package com.example.demo.model.observe;

/**
 *  Observer 类，抽象观察者，为所有的具体观察者定义一个接口，在得到主题对象的通知时更新自己。
 */
public abstract class Observer {
    public abstract void updateState();
}
