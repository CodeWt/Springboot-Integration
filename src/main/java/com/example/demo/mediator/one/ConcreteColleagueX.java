package com.example.demo.mediator.one;

/**
 *  具体同事类,每个具体同事只知道自己的行为，而不了解其它同事类的情况，但他们都认识中介者对象。
 */
public class ConcreteColleagueX extends Colleague {
    public ConcreteColleagueX(Mediator mediator) {
        super(mediator);
    }
    public void send(String msg){
        this.mediator.send(msg,this);
    }

    public void notifyMsg(String msg){
        System.out.println("同事X得到的消息 ： " + msg);
    }
}
