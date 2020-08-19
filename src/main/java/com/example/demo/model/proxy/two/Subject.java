package com.example.demo.model.proxy.two;

/**
 * Subject类，定义了RealSubject 和 Proxy 的共用接口，
 * 这样就在任何使用RealSubject 的地方可以使用 Proxy
 */
public abstract class Subject {
    public abstract void request();
}
