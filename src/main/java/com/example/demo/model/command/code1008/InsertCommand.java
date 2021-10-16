package com.example.demo.model.command.code1008;

public class InsertCommand extends Command {
    String insertMsg;
    Content content;
    String undoMsg;
    public InsertCommand(String insertMsg,Content content){
        this.insertMsg = insertMsg;
        this.content = content;
        undoMsg = content.msg;
    }
    @Override
    public void doIt() {
        content.msg += insertMsg;
//        System.out.println("after doit " + content.msg);
    }

    @Override
    public void undo() {
         content.msg = undoMsg;
    }
}
