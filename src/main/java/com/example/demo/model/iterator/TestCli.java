package com.example.demo.model.iterator;

public class TestCli {
    public static void main(String[] args) {
        ConcreteAggregate aggregate = new ConcreteAggregate();
        aggregate.insertItemByIndex(0,"大鸟");
        aggregate.insertItemByIndex(1,"小菜");
        aggregate.insertItemByIndex(2,"吴天昊");
        aggregate.insertItemByIndex(3,"老外");
        aggregate.insertItemByIndex(4,"张天爱");

        Iterator iterator = new ConcreteIterator(aggregate);
        Object item = iterator.first();
        while (!iterator.isDone()){
            System.out.println("----" + iterator.currentItem());
            System.out.println("++++" + iterator.next());
        }
    }
}
