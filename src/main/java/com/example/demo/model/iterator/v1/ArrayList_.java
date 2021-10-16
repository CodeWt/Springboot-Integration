package com.example.demo.model.iterator.v1;

/**
 *
 * 基于数组的容器，动态扩展大小
 *
 */
public class ArrayList_ implements Collection_ {
    private Object[] objects=new Object[10];
    //当前指针位置，或当前元素个数
    private int index=0;

    public void add(Object o){
        if (index==objects.length){
            Object[] newObjects =new Object[2*objects.length];
            System.arraycopy(objects,0,newObjects,0,objects.length);
            objects=newObjects;
        }
        objects[index++]=o;
    }
    private int size(){
        return this.index;
    }

    public void dis(){
        for (int i = 0; i < objects.length; i++) {
            System.out.println(i + " -- " + objects[i]);
        }
    }
}

