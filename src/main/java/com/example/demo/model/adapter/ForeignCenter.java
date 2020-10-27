package com.example.demo.model.adapter;

public class ForeignCenter {
    private String name;
    public void attackCHN(){
        System.out.println("外籍球员：" + name + "进攻。。");
    }
    public void defenseCHN(){
        System.out.println("外籍球员："+ name + "防守。。");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
