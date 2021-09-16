package com.example.demo.model.singleton;

/**
 *
 * 枚举实现,不仅可以解决线程同步，而且防止反序列化
 *
 */
public enum Singleton08 {
    INSTANCE;


    //业务方法
    public void m(){

    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(()-> System.out.println(Singleton08.INSTANCE.hashCode())).start();

        }
    }
}
