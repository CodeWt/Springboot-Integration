package com.example.demo.thread;

public class ThreadStateTest{
    private static class T extends Thread{
        @Override
        public void run() {
            for (int i = 0;i< 10;i++){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(this.getState());
            }
        }
    }

    public static void main(String[] args) {
        T t = new T();
        System.out.println(t.getState());
        //Runnable分为两个状态 ready 和 running
        t.start();
        try {
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(t.getState());
    }
}
