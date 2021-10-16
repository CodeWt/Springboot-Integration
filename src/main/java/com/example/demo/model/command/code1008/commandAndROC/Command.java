package com.example.demo.model.command.code1008.commandAndROC;

import com.example.demo.model.command.code1008.Content;

public abstract class Command {
    protected Content content;
    protected String insertMsg;

    public Command(){}
    public Command(Content content, String insertMsg){
        this.content = content;
        this.insertMsg = insertMsg;
    }
    public abstract void doIt();
}
