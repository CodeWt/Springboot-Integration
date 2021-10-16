package com.example.demo.model.visitor.v1;

public class Board extends ComputerPart {
    public Board(double price) {
        super(price);
    }

    @Override
    void accept(Visitor visitor) {
        visitor.visitBoardPrice(this);
    }

}
