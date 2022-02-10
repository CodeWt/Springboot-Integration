package com.example.demo.thread.pool.c_026_01_ThreadPool;

import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.RecursiveTask;

public class T12_ForkJoinPool {
    static int[] nums = new int[10*10000];
    static Random random = new Random();
    static {
        for (int i = 0; i < nums.length; i++) {
            nums[i] = random.nextInt(100);
        }
        System.out.println(Arrays.stream(nums).sum());
    }
    static int MAX_NUMS = 666;

    static class AddTaskNonRet extends  RecursiveAction{
        int start;
        int end;
        public AddTaskNonRet(int start,int end){
            this.start=start;
            this.end=end;
        }
        @Override
        protected void compute() {
            if (end-start <= MAX_NUMS){
                long sum = 0l;
                for (int i = start; i < end; i++) {
                    sum+=nums[i];
                }
                System.out.println("from " + start + " to " + end + " => sum : " + sum);
            }else {
                int mid = start + (end-start)/2;
                AddTaskNonRet l = new AddTaskNonRet(start, mid);
                AddTaskNonRet r = new AddTaskNonRet(mid,end);
                l.fork();
                r.fork();
            }
        }
    }

    static class AddTaskRet extends RecursiveTask<Long> {
        int start;
        int end;
        public AddTaskRet(int start,int end){
            this.start=start;
            this.end=end;
        }
        @Override
        protected Long compute() {

            if (end-start<=MAX_NUMS){
                long sum=0L;
                for (int i = start; i < end; i++) sum+=nums[i];
                System.out.println("from " + start + " to " + end + " => sum : " + sum);
                return sum;
            }
            int mid = start + (end-start)/2;
            AddTaskRet l = new AddTaskRet(start, mid);
            AddTaskRet r = new AddTaskRet(mid, end);
            l.fork();
            r.fork();
            return l.join() + r.join();

        }
    }
    public static void main(String[] args) throws IOException {
//        ForkJoinPool forkJoinPool = new ForkJoinPool();
//        AddTaskNonRet addTask = new AddTaskNonRet(0, nums.length);
//        forkJoinPool.execute(addTask);

        ForkJoinPool fjp = new ForkJoinPool();
        AddTaskRet taskRet = new AddTaskRet(0, nums.length);
        fjp.execute(taskRet);
        Long ret = taskRet.join();
        System.out.println(ret);

        System.in.read();
    }
}
