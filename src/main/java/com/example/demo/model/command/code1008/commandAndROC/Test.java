package com.example.demo.model.command.code1008.commandAndROC;

import com.example.demo.model.command.code1008.Content;

public class Test {
    public static void main(String[] args) {
        Content content = new Content("i love china.");
        ChainOfCommand chain = new ChainOfCommand()
                .addCommand(new InsertCommand(content, " forever !"))
                .addCommand(new DeleteCommand(content, "forever"));
        chain.doIt();

    }
}
