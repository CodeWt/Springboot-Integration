package com.example.demo.model.facade;

/**
 * Facade 模式例子
 */
class Fund{
    Stock1 stock1;
    Stock2 stock2;
    Stock3 stock3;
    NationDebt1 debt1;
    Realty1 realty1;
    public Fund(){
        //基金类，他需要了解所有的股票或其他的投资方式的方法或属性进行组合，以备外界调用
        stock1 = new Stock1();
        stock2 = new Stock2();
        stock3 = new Stock3();
        debt1 = new NationDebt1();
        realty1 = new Realty1();
    }
    public void buyFund(){
        stock1.buy();
        stock2.buy();
        stock3.buy();
        debt1.buy();
        realty1.buy();
    }
    public void sellFund(){
        stock1.sell();
        stock2.sell();
        stock3.sell();
        debt1.sell();
        realty1.sell();
    }
}
public class TestTwo {
    public static void main(String[] args) {
        Fund fund = new Fund();
        //参与股票的具体买卖都有基金公司完成。客户端的代码简介明了。
        fund.buyFund();
        fund.sellFund();
    }
}
