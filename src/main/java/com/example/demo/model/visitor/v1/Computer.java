package com.example.demo.model.visitor.v1;

/**
 *
 * 主结构不会变
 *
 */
public class Computer {
    ComputerPart cpu = new Cpu(1000);
    ComputerPart mem = new Mem(800);
    ComputerPart board = new Board(500);
    public void accept(Visitor visitor){
        cpu.accept(visitor);
        mem.accept(visitor);
        board.accept(visitor);
    }
    public static void main(String[] args) {
        Computer computer = new Computer();

        Visitor visitorP = new PersonVisitor("xiaoming");
        computer.accept(visitorP);
        System.out.println(visitorP.totalPrice);

        Visitor visitorC = new CorpVisitor("xiaomi");
        computer.accept(visitorC);
        System.out.println(visitorC.totalPrice);

    }
}
