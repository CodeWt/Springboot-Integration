package com.example.demo.thread;

public class ExceptionLock implements Runnable{
    private int count;
    public synchronized void run(){
        while (true){
            count ++ ;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (count == 5){
                count = count / 0;
            }
            System.out.println(count);
        }
    }

    public static void main(String[] args) {
        ExceptionLock lock = new ExceptionLock();
        new Thread(lock).start();
        new Thread(lock).start();
    }
}
