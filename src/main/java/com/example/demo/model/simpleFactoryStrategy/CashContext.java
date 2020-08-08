package com.example.demo.model.simpleFactoryStrategy;

import com.example.demo.model.simplefactory.two.CashNormal;
import com.example.demo.model.simplefactory.two.CashRebate;
import com.example.demo.model.simplefactory.two.CashReturn;
import com.example.demo.model.simplefactory.two.CashSuper;

/**
 * 策略模式与简单工厂模式结合
 */
public class CashContext {
    CashSuper cashSuper = null;
    public CashContext(String type){
        switch (type){
            case "normal":
                cashSuper = new CashNormal();
                break;
            case "rebate:0.8":
                cashSuper = new CashRebate(0.8);
                break;
            case "return:300:100":
                cashSuper = new CashReturn(300,100);
                break;
        }
    }
    public double getResult(double money){
        return cashSuper.acceptCash(money);
    }
}
