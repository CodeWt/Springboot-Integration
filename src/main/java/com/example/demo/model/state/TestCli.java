package com.example.demo.model.state;

public class TestCli {
    public static void main(String[] args) {
        //设置初始状态为ConcreteStateA
        ConText conText = new ConText(new ConcreteStateA());
        //不断的请求，同时更新状态
        conText.request();
        conText.request();
        conText.request();
        conText.request();

    }
}
