package com.example.demo.thread.juc.c_000;

public class State {
    static void m(){
        System.out.println(Thread.currentThread().getState());
    }
    public static void main(String[] args) {
        Thread t1 = new Thread(State::m);
        System.out.println(t1.getState());
        t1.start();
        System.out.println(t1.getState());
        try {
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(t1.getState());

    }
}
