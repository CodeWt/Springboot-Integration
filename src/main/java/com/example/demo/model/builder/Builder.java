package com.example.demo.model.builder;

/**
 *  Builder 是为创建一个 Product 对象的各个部件指定的抽象接口
 *  抽象建造类，确定产品由两个部件PartA 和 PartB 组成，并且声明一个得到产品建造后的方法 GetResult
 */
public abstract class Builder {
    public abstract void buildPartA();
    public abstract void buildPartB();
    public abstract Product getResult();
}
