package com.example.demo.thread.juc.c_022_RefTypeAndThreadLocal;

import java.io.IOException;
import java.lang.ref.SoftReference;

/**
 *
 * 软引用，实在内存不够会回收
 * 做缓存
 *
 */
public class T02_SoftReference {
    public static void main(String[] args) throws IOException, InterruptedException {
        SoftReference<byte[]> s = new SoftReference<>(new byte[1024*1024*10]);
        System.out.println(s.get());
//        s = null;
        System.gc();
        Thread.sleep(500);
        System.out.println(s.get());
        //再分配一个数组，heap将装不下，系统会垃圾回收，先回收一次，如果内存还不够则干掉弱引用
        byte[] bytes = new byte[1024 * 1024 * 15];
        System.out.println(s.get());
    }
}
