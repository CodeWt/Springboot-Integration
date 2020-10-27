package com.example.demo.model.command;

/**
 *  将一个接受者对象绑定于一个动作，调用接受者相应的操作，以实现execute()
 */
public class ConcreteCommand extends Command {
    public ConcreteCommand(Receiverr receiver) {
        super(receiver);
    }

    @Override
    public void execute() {
        receiver.action();
    }
}
