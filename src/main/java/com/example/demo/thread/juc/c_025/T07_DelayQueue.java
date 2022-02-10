package com.example.demo.thread.juc.c_025;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class T07_DelayQueue {
    static DelayQueue<MyTask> queue = new DelayQueue();
    private static class MyTask implements Delayed {
        String taskName;
        long waitTime;
        public MyTask(String taskName,long waitTime){
            this.taskName = taskName;
            this.waitTime = waitTime;
        }
        @Override
        public long getDelay(TimeUnit unit) {
            return unit.convert(this.waitTime - System.currentTimeMillis(),TimeUnit.MILLISECONDS);
        }

        @Override
        public int compareTo(Delayed o) {
            if (this.getDelay(TimeUnit.MILLISECONDS)-o.getDelay(TimeUnit.MILLISECONDS) > 0) return 1;
            else if (this.getDelay(TimeUnit.MILLISECONDS)-o.getDelay(TimeUnit.MILLISECONDS)<0) return -1;
            else return 0;
        }

        @Override
        public String toString() {
            return this.taskName +"\t"+ this.waitTime;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        long now = System.currentTimeMillis();
        queue.put(new MyTask("t1" ,now+500));
        queue.put(new MyTask("t2", now+1000));
        queue.put(new MyTask("t3" ,now+2500));
        queue.put(new MyTask("t4", now+2000));
        queue.put(new MyTask("t5" , now+1500));
        System.out.println(queue);
        for (int i = 0; i < 5; i++) {
            System.out.println(queue.take());
        }
    }
}
