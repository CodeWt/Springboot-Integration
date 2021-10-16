package com.example.demo.model.builder.code1005;

public class TestCLi {
    public static void main(String[] args) {
        Person person = new Person.PersonBuilder()
                .basicInfo("uuid-1","xiaoming",24)
                .loc("陈塘庄街道", "1-2002-3")
                .weight(64)
//                .score(100)
                .build();
        System.out.println(person);
    }
}
