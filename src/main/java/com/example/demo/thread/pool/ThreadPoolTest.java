package com.example.demo.thread.pool;

import java.util.concurrent.*;

public class ThreadPoolTest {
    public static void test01() throws ExecutionException, InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(1);
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println("-----------");
                System.out.println(1/0);
            }
        };
        Future f = service.submit(r);
//        f.get();//阻塞
        service.shutdown();
    }

    public static void test02(){
        ExecutorService service = Executors.newFixedThreadPool(1);
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println("===========");
                System.out.println(1/0);
            }
        };
        service.execute(r);
        service.shutdown();
    }
    public static void test03(){
        ThreadFactory factory = new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                Thread thread = Executors.defaultThreadFactory().newThread(r);
                thread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
                    @Override
                    public void uncaughtException(Thread t, Throwable e) {
                        System.out.println(t + "" + e);
                        e.printStackTrace();//example
                    }
                });
                return thread;
            }
        };

        ExecutorService service = Executors.newFixedThreadPool(1,factory);
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println("**********");
                System.out.println(1 / 0);
            }
        };

        service.execute(r);
        service.shutdown();
    }
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        test03();
    }
}
