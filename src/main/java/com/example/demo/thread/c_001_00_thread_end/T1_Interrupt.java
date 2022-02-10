package com.example.demo.thread.c_001_00_thread_end;

public class T1_Interrupt {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            long i = 0L;
            while (!Thread.currentThread().isInterrupted()) {
                //若有 sleep,wait 等操作，依然可以在catch里继续处理或停止线程运行
                i++;
            }
            System.out.println("end : " + i);
        });
        t1.start();
        Thread.sleep(3*1000);
        t1.interrupt();
    }
}
