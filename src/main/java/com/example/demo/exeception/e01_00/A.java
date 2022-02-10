package com.example.demo.exeception.e01_00;

public class A {
    ITest iTest;
    public A(ITest iTest){
        this.iTest = iTest;
    }
    public int m1(int a,int b) throws ZeroException {
        if (b==0){
            throw new ZeroException("0不能做除数!");
        }
        return a/b;
    }
}
