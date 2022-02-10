package com.example.demo.model.proxy.v2;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Random;

/**
 *
 * JDK动态代理必须 传接口，根据接口来生成代理类自己的接口方法
 *
 */
public class Plane implements Movable {
    @Override
    public void move() {
        System.out.println("fly...");
        try {
            Thread.sleep(new Random().nextInt(10 * 1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Plane plane = new Plane();//被代理的类
        System.setProperty("sun.misc.ProxyGenerator.saveGeneratedFiles","true");

        //jdk 动态代理，reflection 通过二进制字节码分析类的属性和方法。 参数分别为：
        // 1.加载动态生成的代理类用的classloader(代理与被代理一般是同一个Loader加载，不能分别是由平行的loader加载)，
        // 2.代理类代理的接口，
        // 3.代理的处理对象
        Movable m = (Movable) Proxy.newProxyInstance(Plane.class.getClassLoader(),
                new Class[]{Movable.class}, //plane.class.getInterfaces
                new LogProxy(plane));
        m.move();
    }
}
class LogProxy implements InvocationHandler{

    Movable movable;
    public LogProxy(Movable movable){
        this.movable = movable;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //proxy 为反射生成的代理类对象本身，method为被代理的接口方法，args为方法需要传参
        System.out.println(proxy.getClass().getName());
        System.out.println("start --> " + method.getName());
        Object o = method.invoke(movable, args);
        System.out.println("end --> " + method.getName());
        return o;
    }

}
