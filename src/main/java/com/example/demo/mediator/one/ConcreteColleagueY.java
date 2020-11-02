package com.example.demo.mediator.one;

public class ConcreteColleagueY extends Colleague {
    public ConcreteColleagueY(Mediator mediator) {
        super(mediator);
    }
    public void send(String msg){
        this.mediator.send(msg,this);
    }

    public void notifyMsg(String msg){
        System.out.println("同事Y得到的消息 ： " + msg);
    }
}
