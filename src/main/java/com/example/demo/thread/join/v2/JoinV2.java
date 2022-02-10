package com.example.demo.thread.join.v2;

public class JoinV2 {
    private static class MyThread extends Thread{
        private Thread t;
        public MyThread(){}

        public MyThread(String name) {
            super(name);
        }

        public MyThread(String name, Thread thread) {
            super(name);
            this.t = thread;
        }

        @Override
        public void run() {
            try {
                if (t!=null){
                    t.join();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " start.");
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName() + " - " + i);
            }
            System.out.println(Thread.currentThread().getName() + " end.");
        }
    }

    public static void main(String[] args) {
        MyThread t3 = new MyThread("t3");
        MyThread t2 = new MyThread("t2",t3);
        MyThread t1 = new MyThread("t1",t2);
        t1.start();
        t2.start();
        t3.start();

    }
}
