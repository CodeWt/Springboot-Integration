package com.example.demo.model.composite;

import java.util.ArrayList;
import java.util.List;

/**
 *  定义支节点行为，用来存储子部件，在Component接口中实现与子部件有关的操作，例如 add 和 remove 操作
 */
public class Composite extends Component {
    //一个子对象集合用来存储其下属的支节点和叶节点
    private List<Component> children = new ArrayList<>();
    public Composite(String name){
        super(name);
    }

    @Override
    public void add(Component component) {
        children.add(component);
    }

    @Override
    public void remove(Component component) {
        children.remove(component);
    }

    //显示其支节点名称，并对下级进行遍历
    @Override
    public void display(int depth) {
        StringBuilder b = new StringBuilder();
        for (int i = 0;i < depth;i++){
            b.append("-");
        }
        System.out.println(b.toString() + name);
        for (Component component: children){
            component.display(depth + 2);
        }
    }
}
