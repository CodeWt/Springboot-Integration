package com.example.demo.model.command.code1008;

public class DeleteCommand extends Command {
    private Content content;
    private String msg;
    private String undoMsg;

    public DeleteCommand(Content content,String msg) {
        this.content = content;
        this.msg = msg;
        this.undoMsg = content.msg;
    }

    @Override
    public void doIt(){
        if (msg==null&&"".equals(msg)){
            return;
        }
        if (!content.msg.contains(msg)){
            return;
        }
        this.content.msg = content.msg.replaceAll(msg,"");
    }

    @Override
    public void undo() {
        this.content.msg = undoMsg;
    }
}
