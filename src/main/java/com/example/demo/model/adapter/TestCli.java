package com.example.demo.model.adapter;

public class TestCli {
    public static void main(String[] args) {
        Player g = new Guards("麦克格雷迪");
        g.attack();
        Player ym = new Translator("姚明");
        ym.attack();
        ym.defense();
    }
}
