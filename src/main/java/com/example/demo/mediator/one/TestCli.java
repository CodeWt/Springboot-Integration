package com.example.demo.mediator.one;

/**
 *  客户端调用
 */
public class TestCli {
    public static void main(String[] args) {
        ConcreteMediator mediator = new ConcreteMediator();
        //让两个同事类认识中介者对象
        ConcreteColleagueX cx = new ConcreteColleagueX(mediator);
        ConcreteColleagueY cy = new ConcreteColleagueY(mediator);
        //让中介者认识所有的同事类对象
        mediator.setColleagueX(cx);
        mediator.setColleagueY(cy);
        //具体同事类对象的发送信息都是通过中介者转发
        cx.send("您吃过了吗 ？？");
        cy.send("还没有呢。。。");
    }
}
