package com.example.demo.model.decorator.code0917;

public abstract class Decorator extends Component{
    protected String decoratorName;
    public Decorator(String decoratorName){
        this.decoratorName = decoratorName;
    }
    //聚合Component
    protected Component component;
    public Decorator(String decoratorName,Component component){
        this.decoratorName = decoratorName;
        this.component = component;
    }

    //默认通用装饰
    protected void decorateM(){
        component.decorateM();
    }
}
