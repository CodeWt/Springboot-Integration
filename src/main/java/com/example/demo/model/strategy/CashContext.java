package com.example.demo.model.strategy;

import com.example.demo.model.simplefactory.two.CashSuper;

/**
 * 策略模式
 */
public class CashContext {
    private CashSuper cashSuper;
    public CashContext(CashSuper cashSuper){
        this.cashSuper = cashSuper;
    }
    public double getResult(double money){
        return cashSuper.acceptCash(money);
    }
}
