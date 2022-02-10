package com.example.demo.thread.juc.c_026_00_interview_A1B2;

import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.TransferQueue;

public class T13_00_Transfer {
    static TransferQueue<String> transfer = new LinkedTransferQueue<>();
    public static void main(String[] args) {
        char[] chas = "ABCD".toCharArray();
        char[] nums = "1234".toCharArray();
        new Thread(()->{
            for (int i = 0; i < chas.length; i++) {
                System.out.print(chas[i]);
                try {
                    transfer.transfer("ok");
                    transfer.take();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"T1").start();
        new Thread(()->{
            for (int i = 0; i < nums.length; i++) {
                try {
                    transfer.take();
                    System.out.print(nums[i]);
                    transfer.put("ok");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"T2").start();
    }
}
