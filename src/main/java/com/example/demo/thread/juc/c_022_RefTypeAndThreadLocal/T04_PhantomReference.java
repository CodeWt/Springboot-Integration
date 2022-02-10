package com.example.demo.thread.juc.c_022_RefTypeAndThreadLocal;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * 虚引用
 *
 */
public class T04_PhantomReference {
    private static final List<Object> LIST = new ArrayList<>();
    //被回收的虚引用会被放入此队列
    private static final ReferenceQueue<M> QUEUE = new ReferenceQueue();

    public static void main(String[] args) {
        PhantomReference<M> phantomReference = new PhantomReference<>(new M(),QUEUE);
        new Thread(()->{
            while (true){
                LIST.add(new byte[1024 * 1024]);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    Thread.currentThread().interrupt();
                }
                //虽有指向的对象，但是拿不到值
                System.out.println(phantomReference.get());
            }
        }).start();
        new Thread(()->{
            while (true){
                Reference<? extends M> reference = QUEUE.poll();
                if (reference!=null){
                    System.out.println("========虚引用对象被回收了========" + reference);
                }
            }
        }).start();
    }
}
