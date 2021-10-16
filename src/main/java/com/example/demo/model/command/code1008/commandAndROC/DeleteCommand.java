package com.example.demo.model.command.code1008.commandAndROC;

import com.example.demo.model.command.code1008.Content;

public class DeleteCommand extends Command{
    public DeleteCommand(Content content, String insertMsg) {
        super(content, insertMsg);
    }

    @Override
    public void doIt() {
        System.out.println("do it delete.");
    }
}
