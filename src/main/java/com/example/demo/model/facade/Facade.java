package com.example.demo.model.facade;

/**
 * Facade外观类，知道哪些子系统类负责处理请求，将客户的请求代理给适当的子系统对象
 * 他需要了解所有的子系统的方法或属性，进行组合，以备外界调用
 */
public class Facade {
    SubSystemOne subSystemOne;
    SubSystemTwo subSystemTwo;
    SubSystemThree subSystemThree;
    SubSystemFour subSystemFour;
    public Facade(){
        subSystemOne = new SubSystemOne();
        subSystemTwo = new SubSystemTwo();
        subSystemThree = new SubSystemThree();
        subSystemFour = new SubSystemFour();
    }
    public void methodA(){
        System.out.println("------ 方法A的组合 ：");
        subSystemOne.methodOne();
        subSystemThree.methodThree();
        subSystemFour.methodFour();
    }

    public void methodB(){
        System.out.println("------- 方法B的组合 ：");
        subSystemFour.methodFour();
        subSystemTwo.methodTwo();
        subSystemOne.methodOne();
    }
}

/**
 *  子系统类的集合实现子系统的功能，处理Facade对象指派的任务。
 *  注意子类中没有Facade的任何信息，即没有对Facade对象的引用
 */
class SubSystemOne{
    public void methodOne(){
        System.out.println("子系统方法 1111");
    }

}
class SubSystemTwo{
    public void methodTwo(){
        System.out.println("子系统方法 2222");
    }
}

class SubSystemThree{
    public void methodThree(){
        System.out.println("子系统方法 3333");
    }
}
class SubSystemFour{
    public void methodFour(){
        System.out.println("子系统方法 4444");
    }
}
class TestClient{
    public static void main(String[] args) {
        Facade facade = new Facade();
        facade.methodA();
        facade.methodB();
    }
}