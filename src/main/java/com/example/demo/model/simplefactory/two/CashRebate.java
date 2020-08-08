package com.example.demo.model.simplefactory.two;

public class CashRebate extends CashSuper {
    //折扣率
    private double moneyRebate;
    public CashRebate(double moneyRebate){
        this.moneyRebate = moneyRebate;
    }
    @Override
    public double acceptCash(double money) {
        return money * moneyRebate;
    }
}
