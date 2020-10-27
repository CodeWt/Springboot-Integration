package com.example.demo.iterator;

/**
 *  具体的迭代器类，实现迭代器抽象类声明的方法
 */
public class ConcreteIterator extends Iterator {
    //定义一个具体聚集对象
    private ConcreteAggregate aggregate;
    private int current = 0;

    public ConcreteIterator(ConcreteAggregate aggregate){
        this.aggregate = aggregate;
    }

    @Override
    public Object first() {
        return aggregate.getItemByIndex(0);
    }

    @Override
    public Object next() {
        Object ret = null;
        current ++;
        if (current < aggregate.count()){
            ret = aggregate.getItemByIndex(current);
        }
        return ret;
    }
    //判断当前是否遍历到结尾，是返回true
    @Override
    public boolean isDone() {
        return current >= aggregate.count() ? true : false;
    }

    @Override
    public Object currentItem() {
        return aggregate.getItemByIndex(current);
    }
}
