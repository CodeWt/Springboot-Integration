package com.example.demo.model.command;

/**
 *  用来声明执行操作的接口
 */
public abstract class Command {
    protected Receiverr receiver;
    public Command(Receiverr receiver){
        this.receiver = receiver;
    }

    abstract public void execute();
}
