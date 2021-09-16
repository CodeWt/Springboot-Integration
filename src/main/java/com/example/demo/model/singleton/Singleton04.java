package com.example.demo.model.singleton;

/**
 *
 * synchronized 效率低
 *
 */
public class Singleton04 {
    public static Singleton04 INSTANCE;
    private Singleton04(){

    }
    public static synchronized Singleton04 getInstance(){
        if (INSTANCE==null){
            INSTANCE = new Singleton04();
        }
        return INSTANCE;
    }


    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(()-> System.out.println(Singleton04.getInstance().hashCode())).start();
        }
    }
}
