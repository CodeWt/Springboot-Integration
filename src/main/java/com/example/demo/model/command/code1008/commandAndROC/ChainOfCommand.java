package com.example.demo.model.command.code1008.commandAndROC;

import java.util.ArrayList;
import java.util.List;

public class ChainOfCommand extends Command{
    List<Command> list = new ArrayList<>();

    public ChainOfCommand addCommand(Command command){
        list.add(command);
        return this;
    }

    @Override
    public void doIt() {
        for (Command comm: list) {
            comm.doIt();
        }
    }

}
