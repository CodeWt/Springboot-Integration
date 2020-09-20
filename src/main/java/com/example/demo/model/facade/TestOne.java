package com.example.demo.model.facade;

/**
 * 未用facade模式改造前的例子
 */
class Stock1{
    //买入股票
    public void buy(){
        System.out.println("买入股票 1111");
    }
    //卖出股票
    public void sell(){
        System.out.println("卖出股票 1111");
    }
}
class Stock2{
    //买入股票
    public void buy(){
        System.out.println("买入股票 2222");
    }
    //卖出股票
    public void sell(){
        System.out.println("卖出股票 2222");
    }
}class Stock3{
    //买入股票
    public void buy(){
        System.out.println("买入股票 3333");
    }
    //卖出股票
    public void sell(){
        System.out.println("卖出股票 3333");
    }
}

/**
 *  国债1
 */
class NationDebt1{
    //买入国债1
    public void buy(){
        System.out.println("买入 国债 1");
    }
    //卖出国债1
    public void sell(){
        System.out.println("卖出 国债 1");
    }
}
/**
 * 房地产1
 */
class Realty1{
    //买入房地产1
    public void buy(){
        System.out.println("买入 房地产 1");
    }
    //卖出房地产1
    public void sell(){
        System.out.println("卖出 房地产 1");
    }
}
public class TestOne {
    public static void main(String[] args) {
        Stock1 stock1 = new Stock1();
        Stock2 stock2 = new Stock2();
        Stock3 stock3 = new Stock3();
        NationDebt1 debt1 = new NationDebt1();
        Realty1 realty1 = new Realty1();
        /**
         *  用户需要了解股票、国债、房产情况，需要参与这些项目的具体买和卖。耦合性很高。
         */
        stock1.buy();
        stock2.buy();
        stock3.buy();
        debt1.buy();
        realty1.buy();

        stock1.sell();
        stock2.sell();
        stock3.sell();
        debt1.sell();
        realty1.sell();
    }
}