package com.example.demo.thread.c_001_00_thread_end;

/**
 *
 * 相对优雅的结束线程方式
 *
 */
public class T1_Volatile {
    private static volatile boolean flag = true;
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            long i = 0L;
            while (flag) {
                //wait recv accept 无法进入下一次循环，即无法停掉线程运行
                i++;
            }
            System.out.println("end : " + i);
            //5572395950
            //5513956783
        });

        t1.start();
        Thread.sleep(3*1000);
        flag=false;

    }
}
