package com.example.demo.model.singleton;

/**
 *
 * double check
 *
 */
public class Singleton06 {
    private static volatile Singleton06 INSTANCE;//JIT
    private Singleton06(){}
    public static Singleton06 getInstance(){
        //first check
        if(INSTANCE == null){
            synchronized (Singleton06.class){
                //second check
                if (INSTANCE==null){
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    INSTANCE = new Singleton06();
                }
            }
        }
        return INSTANCE;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(()-> System.out.println(Singleton06.getInstance().hashCode())).start();

        }
    }
}
