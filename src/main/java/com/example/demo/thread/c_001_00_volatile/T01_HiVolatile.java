package com.example.demo.thread.c_001_00_volatile;

/**
 *
 *
 *
 */
public class T01_HiVolatile {

//    private static boolean flag=true;
    private static volatile boolean flag=true;
    static void running(){
        System.out.println("t1 start");
        while (flag){

        }
        System.out.println("t1 end.");
    }

    public static void main(String[] args) throws InterruptedException {
        new Thread(T01_HiVolatile::running,"t1").start();
        Thread.sleep(1000);
        flag=false;
    }

}
