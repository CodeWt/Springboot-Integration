package com.example.demo.model.singleton;

/**
 *
 * 饿汉式单利，static变量，jvm类加载时初始化实例，只加载一次，保证线程安全
 *
 * 缺点不管用不用 都要实例化一个实例在内存中（推荐使用，最常见需简单写法）
 *
 */
public class Singleton01 {
    private static final Singleton01 INSTANCE = new Singleton01();

    private Singleton01(){
    }

    public static Singleton01 getInstance(){
        return INSTANCE;
    }
}
