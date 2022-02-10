package com.example.demo.thread.c_001_03_ordering;

/**
 *
 * 正确写法
 *
 */
public class T03_ThisEscape_ {
    private int num=8;
    private static Thread t;
    public T03_ThisEscape_(){
        t = new Thread(() -> System.out.println(this.num));
    }
    public void start(){
        t.start();
    }

    public static void main(String[] args) {
        new T03_ThisEscape_();
        t.start();
    }
}
