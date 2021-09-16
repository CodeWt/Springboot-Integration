package com.example.demo.model.singleton;

/**
 *
 *  静态内部类方式
 *  JVM保证单例
 *  加载外部类时 不会加载内部类，实现lazy loading
 *
 */
public class Singleton07 {
    private Singleton07(){}
    private static class SinglelonHolder{
        private static final Singleton07 INSTANCE = new Singleton07();
    }
    public static Singleton07 getInstance(){
        return SinglelonHolder.INSTANCE;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(()-> System.out.println(Singleton07.getInstance().hashCode())).start();
        }
    }
}
