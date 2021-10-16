package com.example.demo.model.command.code1008.commandAndROC;

import com.example.demo.model.command.code1008.Content;

public class InsertCommand extends Command {

    public InsertCommand(Content content, String insertMsg) {
        super(content, insertMsg);
    }

    @Override
    public void doIt() {
        System.out.println("do it insert.");
    }
}
