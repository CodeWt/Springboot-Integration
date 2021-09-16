package com.example.demo.model.singleton;

/**
 *
 *  懒汉式lazy loading
 *
 *  缺点线程不安全
 *
 */
public class Singleton03
{
    private static Singleton03 INSTANCE;
    private Singleton03(){

    }

    public static Singleton03 getInstance(){
        if (INSTANCE==null){
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            INSTANCE = new Singleton03();
        }
        return INSTANCE;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(()-> System.out.println(Singleton03.getInstance().hashCode())).start();
        }
    }
}
