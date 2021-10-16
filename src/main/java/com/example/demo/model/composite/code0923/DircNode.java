package com.example.demo.model.composite.code0923;

import java.util.ArrayList;
import java.util.List;

public class DircNode extends Node{
    List<Node> nodes = new ArrayList<>();

    public DircNode(String name) {
        super(name);
    }

    public void addNode(Node node){
        nodes.add(node);
    }
}
