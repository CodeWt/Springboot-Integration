package com.example.demo.model.strategy.msb0914;

public class TestReflect {
    private int a = 100;
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        final Object o = Class.forName("com.example.demo.model.strategy.msb0914.TestReflect").newInstance();
        System.out.println(((TestReflect)o).a);
    }
}
