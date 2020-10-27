package com.example.demo.iterator;

import java.util.ArrayList;
import java.util.List;

/**
 *  具体聚集类 继承Aggregate
 */
public class ConcreteAggregate extends Aggregate {
    //声明一个List泛型变量，用于存放聚合对象
    private List<Object> objects = new ArrayList<>();

    @Override
    public Iterator createIterator() {
        return new ConcreteIterator(this);
    }
    //返回聚集总个数
    public int count(){
        return objects.size();
    }
    public Object getItemByIndex(int index){
        return objects.get(index);
    }

    public void insertItemByIndex(int index,Object val){
        objects.add(index,val);
    }
}
