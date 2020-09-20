package com.example.demo.model.builder;

import java.util.ArrayList;
import java.util.List;

/**
 * 具体的产品Product类——产品类，由多个部件组成
 */
public class Product {
    List<String> parts = new ArrayList<>();

    /**
     * 添加产品部件
     *
     * @param part
     */
    public void addPart(String part) {
        parts.add(part);
    }

    /**
     * 列举所有产品的部件
     */
    public void dis() {
        System.out.println("\n 产品 创建---");
        for (String part :
                parts) {
            System.out.println(part);
        }
    }
}
