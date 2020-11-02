package com.example.demo.model.mediator.one;

/**
 *  具体中介者对象，实现抽象类的方法，他需要知道所有具体同事类，并从具体同事接收消息，项具体同事对象发送命令。
 */
public class ConcreteMediator extends Mediator {
    private ConcreteColleagueX colleagueX;
    private ConcreteColleagueY colleagueY;

    public void setColleagueX(ConcreteColleagueX colleagueX) {
        this.colleagueX = colleagueX;
    }

    public void setColleagueY(ConcreteColleagueY colleagueY) {
        this.colleagueY = colleagueY;
    }

    @Override
    public void send(String msg, Colleague colleague) {
        //根据对象进行选择路由判断通知的对象
        if (colleague == colleagueX){
            colleagueY.notifyMsg(msg);
        }else {
            colleagueY.notifyMsg(msg);
        }
    }
}
