package com.example.demo.flink.entity;

import java.io.Serializable;

public class User implements Serializable {
    private String name;
    private String pass;
    private Integer age;
    private Integer grade;

    public User(String name, String pass, Integer age, Integer grade) {
        this.name = name;
        this.pass = pass;
        this.age = age;
        this.grade = grade;
    }
    public User(String name,String pass){
        this.name = name;
        this.pass = pass;
    }

    public User(){}
    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}