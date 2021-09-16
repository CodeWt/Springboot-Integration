package com.example.demo.model.strategy.msb0914.third;

/**
 *
 * 策略模式
 *
 * @param <T>
 */
@FunctionalInterface
public interface Compartor<T> {
    int compareTo(T o1,T o2);

    default void m1(){
        System.out.println("java8 default method for 向前兼容");
    }

    default void m2(){
        System.out.println("lamada表达式加入后为向前兼容");
    }
}
