package com.example.demo.model.command;

public class TestCli {
    public static void main(String[] args) {
        Receiverr receiver = new Receiverr();
        //创建一个具体的命令对象并传入它的接受者
        Command c = new ConcreteCommand(receiver);
        Invoker i = new Invoker();
        i.setCommand(c);
        i.executeCommand();
    }
}
