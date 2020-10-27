package com.example.demo.model.singleton;

/**
 *  非线程安全的单例模式
 *  定义一个 getInstance 操作，允许客户访问它的唯一实例。getInstance 是一个静态的方法，主要负责创建自己的惟一的实例
 */
public class NonThreadSecuritySingleton {
    private static NonThreadSecuritySingleton singleton;
    private NonThreadSecuritySingleton(){}

    public static NonThreadSecuritySingleton getInstance(){
        if (singleton == null){
            singleton = new NonThreadSecuritySingleton();
        }
        return singleton;
    }
}
class TestCli{
    public static void main(String[] args) {
        NonThreadSecuritySingleton s1 = NonThreadSecuritySingleton.getInstance();
        NonThreadSecuritySingleton s2 = NonThreadSecuritySingleton.getInstance();
        System.out.println(s1 == s2);
    }
}