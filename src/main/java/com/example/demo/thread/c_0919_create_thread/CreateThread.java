package com.example.demo.thread.c_0919_create_thread;

import java.util.concurrent.*;

public class CreateThread {
    static class MyThread extends Thread{
        @Override
        public void run() {
            System.out.println("MyThread exe");
        }
    }

    static class MyRun implements Runnable{
        @Override
        public void run() {
            System.out.println("MyRun exe..");
        }
    }

    static class MyCall implements Callable<String>{
        @Override
        public String call() throws Exception {
            System.out.println("MyCall exe ..");
            return "success";
        }
    }
    //创建启动线程的5种方法
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        new MyThread().start();
        new Thread(new MyRun()).start();
        new Thread(()-> System.out.println("lamada myRun")).start();
        ExecutorService service = Executors.newCachedThreadPool();
        //没有返回值
        service.execute(new MyRun());
        //有返回值并且可以传Runable和Callable
        Future<String> future = service.submit(new MyCall());
        String s = future.get();
        System.out.println(s);

        //FutureTask实现了Runable和Future兼具其功能
        FutureTask<String> futureTask = new FutureTask<String>(new MyCall());
        Thread thread = new Thread(futureTask);
        thread.start();
        String s1 = futureTask.get();
        System.out.println(s1);
    }
}
