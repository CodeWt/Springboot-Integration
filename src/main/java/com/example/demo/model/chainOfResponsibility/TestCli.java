package com.example.demo.model.chainOfResponsibility;

/**
 *  客户端代码，向链上的具体处理者对象提交请求
 */
public class TestCli {
    public static void main(String[] args) {
        Handler h1 = new ConcreteHandlerX();
        Handler h2 = new ConcreteHandlerY();
        Handler h3 = new ConcreteHandlerZ();
        //设置职责链上家与下家
        h1.setSuccessor(h2);
        h2.setSuccessor(h3);
        int[] reqs = new int[]{2,12,24,30,27};
        for (int req : reqs){
            h1.handleRequest(req);
        }
    }
}
