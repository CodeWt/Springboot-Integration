package com.example.demo.model.simplefactory.one;

import com.example.demo.exeception.MyException;

public class DivOperater extends Operator {
    @Override
    public double getResult() throws MyException {
        if (this.getNumberB() == 0) throw new MyException("除数不能为零 ！");
        return this.getNumberA() / this.getNumberB();
    }
}
