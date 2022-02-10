package com.example.demo.thread.pool.c_026_01_ThreadPool;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 底层调用的是ForkJoinPool
 * 每个线程维护一个队列，也可以去其它线程维护的队列偷过来任务执行
 *
 */
public class T11_WorkStealingPool {
    static class Task implements Runnable{
        int taskId;
        int time;
        public Task(int taskId,int time){
            this.taskId=taskId;
            this.time = time;
        }
        @Override
        public void run() {
            try {
                Thread.sleep(time);
                System.out.println(Thread.currentThread().getName() + " run " + this.toString() + " finished.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        @Override
        public String toString() {
            return "task_" + taskId +"_"+ this.time;
        }
    }
    public static void main(String[] args) throws IOException {
        ExecutorService service = Executors.newWorkStealingPool();
        System.out.println(Runtime.getRuntime().availableProcessors());
        for (int i = 0; i < 7; i++) {
            service.execute(new Task(i,3000));//daemon
        }
        //产生的是精灵线程(后台、守护线程)，主线程不阻塞，看不到输出
        System.in.read();
    }
}
