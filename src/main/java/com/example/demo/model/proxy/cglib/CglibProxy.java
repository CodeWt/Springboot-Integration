package com.example.demo.model.proxy.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibProxy {
    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Tank.class);
        enhancer.setCallback(new TimeProxy());
        Tank tank = (Tank) enhancer.create();
        tank.move();
        tank.fire();
    }
}

class TimeProxy implements MethodInterceptor {

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println(o.getClass().getSuperclass().getName() + "---" + method.getName());
        long start = System.currentTimeMillis();
        Object o1 = methodProxy.invokeSuper(o, objects);
//        Object o1 = method.invoke(new Tank(),objects);
        System.out.println("共用时 ： " + (System.currentTimeMillis() - start));
        return o1;

    }
}
