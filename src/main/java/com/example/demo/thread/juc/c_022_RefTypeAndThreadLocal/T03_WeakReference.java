package com.example.demo.thread.juc.c_022_RefTypeAndThreadLocal;

import java.lang.ref.WeakReference;

/**
 *
 * 弱引用遭到GC就会被回收
 *
 */
public class T03_WeakReference {
    public static void main(String[] args) {
        WeakReference<M> m = new WeakReference<>(new M());
        System.out.println(m.get());
        System.gc();
        System.out.println(m.get());

        ThreadLocal<M> tl = new ThreadLocal<>();
        tl.set(new M());
        tl.remove();
    }
}
