package com.example.demo.model.composite.code0923;

public abstract class Node {
    String name;
    public Node(String name){
        this.name = name;
    }
    void printNode(){
        System.out.print(this.name);
        System.out.println();
    }
}
