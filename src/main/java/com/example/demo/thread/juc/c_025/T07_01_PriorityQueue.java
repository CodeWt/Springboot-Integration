package com.example.demo.thread.juc.c_025;

import java.util.PriorityQueue;

public class T07_01_PriorityQueue {
    public static void main(String[] args) {
        PriorityQueue<String> q = new PriorityQueue<>();
        q.add("b");
        q.add("c");
        q.add("a");
        q.add("z");
        q.add("d");
        for (int i = 0; i < 5; i++) {
//            System.out.println(q.peek());
            System.out.println(q.poll());
        }
    }
}
