package com.example.demo.model.chainOfResponsibility;

/**
 *  具体的处理者类，处理他所负责的请求，可访问它的后继者，如果可处理该请求就处理之，否则就将该请求转发给它的后继者
 */
public class ConcreteHandlerX extends Handler {
    @Override
    public void handleRequest(int request) {
        if (request >= 0 && request < 10){
            System.out.println(this.getClass().getName() + " 处理请求 " + request) ;
        }else if (successor != null){
            //转移到下一位去处理请求
            successor.handleRequest(request);
        }
    }
}
