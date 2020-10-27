package com.example.demo.model.chainOfResponsibility;

/**
 *  定义一个处理请示的接口
 */
public abstract class Handler {
    protected Handler successor;
    //设置继任者
    public void setSuccessor(Handler successor){
        this.successor = successor;
    }

    public abstract void handleRequest(int request);
}
