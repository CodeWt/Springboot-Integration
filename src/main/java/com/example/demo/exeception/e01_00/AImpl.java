package com.example.demo.exeception.e01_00;

public class AImpl extends A {
    public AImpl(ITest iTest) {
        super(iTest);
    }

    @Override
    public int m1(int a, int b) {
        return 1+1;
    }
}
