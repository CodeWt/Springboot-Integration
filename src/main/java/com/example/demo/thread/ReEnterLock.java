package com.example.demo.thread;

public class ReEnterLock {
    synchronized void m(){
        System.out.println("m start ...");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("m end ...");
    }

    public static void main(String[] args) {
        new TT().m();
    }
}
class TT extends ReEnterLock{
    synchronized void m(){
        System.out.println("child m start ...");
        super.m();
        System.out.println("child m end ...");
    }
}