package com.example.demo.mediator.one;

/**
 *  抽象中介者，定义了同事对象到中介者对象的接口
 */
public abstract class Mediator {
    //定义一个抽象的发送消息方法，得到同事对象和发送信息
    public abstract void send(String msg,Colleague colleague);
}
