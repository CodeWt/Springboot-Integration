package com.example.demo.model.adapter;

public class Translator extends Player {
    private ForeignCenter foreignCenter = new ForeignCenter();
    public Translator(String name) {
        super(name);
        foreignCenter.setName(name);
    }

    @Override
    public void attack() {
        foreignCenter.attackCHN();
    }

    @Override
    public void defense() {
        foreignCenter.defenseCHN();
    }
}
