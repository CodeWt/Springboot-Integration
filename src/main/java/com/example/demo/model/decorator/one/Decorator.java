package com.example.demo.model.decorator.one;

/**
 * 装饰抽象类，继承了Component,从外类来扩展Component类的功能，
 * 但对于Component来说，是无需知道Decorator的存在的
 */
public class Decorator extends Component{
    protected Component component;
    public void setComponent(Component component){
        this.component = component;
    }

    @Override
    public void operation() {
        if (component != null){
            component.operation();
        }
    }
}
