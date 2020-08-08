package com.example.demo.model.simplefactory.two;

/**
 * 满多少返多少(例如满300返还100)
 */
public class CashReturn extends CashSuper {
    private double moneyCondition;
    private double moneyReturn;

    public CashReturn(double moneyCondition,double moneyReturn){
        this.moneyCondition = moneyCondition;
        this.moneyReturn = moneyReturn;
    }

    @Override
    public double acceptCash(double money) {
        if (money >= moneyCondition){
            return money - moneyReturn;
        }
        return money;
    }
}
