package com.example.demo.model.builder;

/**
 *  指挥者，是构建一个使用builder接口的对象
 */
public class Director {
    public void directConstructProduct(Builder builder){
        builder.buildPartA();
        builder.buildPartB();
    }
}
