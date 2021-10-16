package com.example.demo.model.iterator.v2;

public class ArrayList_ implements Collection_,Iterator_{

    private Object[] objects = new Object[10];
    private int index=0;

    @Override
    public void add(Object o) {
        if (index==objects.length){
            Object[] newObjects=new Object[2*objects.length];
            System.arraycopy(objects,0,newObjects,0,objects.length);
            objects=newObjects;
        }
        objects[index++]=o;
    }

    @Override
    public int size() {
        return this.index;
    }

    @Override
    public Iterator_ iterator() {
        this.pos=0;
        return this;
    }

    //迭代位置定位
    private int pos = 0;

    @Override
    public boolean hasNext() {

        if (objects[pos]==null) return false;
        return true;
    }

    @Override
    public Object next() {
        return objects[pos++];
    }
}
