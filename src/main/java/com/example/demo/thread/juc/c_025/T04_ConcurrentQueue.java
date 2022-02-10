package com.example.demo.thread.juc.c_025;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class T04_ConcurrentQueue {
    public static void main(String[] args) {
        Queue<String> queue = new ConcurrentLinkedQueue<>();
        for (int i = 0; i < 10; i++) {
            System.out.println(queue.offer("offer-"+i));
            queue.add("add-" + i);
        }
        System.out.println(queue.size());
        String peek = queue.peek();
        System.out.println(peek);
        System.out.println(queue.size());
        String poll = queue.poll();
        System.out.println(poll);
        System.out.println(queue.size());
    }
}
