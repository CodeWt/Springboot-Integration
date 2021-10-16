package com.example.demo.model.iterator;

/**
 *  迭代抽象类，用于定义得到开始对象、得到下一个对象，判断是否到结尾。当前对象等抽象方法，统一接口。
 */
public abstract class Iterator{
    public abstract Object first();
    public abstract Object next();
    public abstract boolean isDone();
    public abstract Object currentItem();
}
