package com.example.demo.model.template;

/**
 *  实现了一个模板方法，定义了算法的骨架，具体子类将重新定义抽象方法以实现一个算法的步骤
 */
public abstract class AbstractClass {
    /**
     *  把一些抽象的行为放到子类中去实现
     */
    public abstract void primitiveOperation_1();
    public abstract void primitiveOperation_2();

    /**
     * 模板方法，给出了逻辑的骨架，而逻辑的组成是一些相应的抽象操作，它们都推迟到子类去实现。
     */
    public void templateMethod(){
        System.out.println("step 1 : ...");
        primitiveOperation_1();
        primitiveOperation_2();
        System.out.println("step ....");
    }
}
