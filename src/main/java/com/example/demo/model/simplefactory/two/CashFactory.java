package com.example.demo.model.simplefactory.two;

/**
 * 简单工厂模式
 */
public class CashFactory {
    public static CashSuper createCashAccept(String type){
        CashSuper cashSuper = null;
        switch (type){
            case "normal":
                cashSuper = new CashNormal();
                return cashSuper;
            case  "rebate:0.8":
                cashSuper = new CashRebate(0.8);
                return cashSuper;
            case "return:300:100":
                cashSuper = new CashReturn(300,100);
                return cashSuper;
        }
        return cashSuper;
    }
}
