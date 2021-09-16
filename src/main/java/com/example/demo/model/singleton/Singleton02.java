package com.example.demo.model.singleton;

/**
 *
 * 同01
 *
 */
public class Singleton02 {
    public static final Singleton02 INSTANCE;
    static {
        INSTANCE = new Singleton02();
    }
    private Singleton02(){

    }
    public static Singleton02 getInstance(){
        return INSTANCE;
    }

}
