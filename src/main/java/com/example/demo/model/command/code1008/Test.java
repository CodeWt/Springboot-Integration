package com.example.demo.model.command.code1008;

public class Test {
    public static void main(String[] args) {
        Content content = new Content("i love china.");
        InsertCommand insertCommand = new InsertCommand("forever!",content);
        insertCommand.doIt();
        System.out.println(content.msg);
//        insertCommand.undo();
//        System.out.println(content.msg);

        DeleteCommand deleteCommand = new DeleteCommand(content, ".forever");
        deleteCommand.doIt();
        System.out.println(content.msg);
        deleteCommand.undo();
        System.out.println(content.msg);

    }
}
