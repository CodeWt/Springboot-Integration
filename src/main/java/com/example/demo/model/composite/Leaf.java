package com.example.demo.model.composite;

/**
 *  在组合中表示叶节点对象，叶节点没有子节点
 */
public class Leaf extends Component {
    public Leaf(String name){
        super(name);
    }
    //由于叶子没有再增加分支和树叶，所以add 和 remove方法实现它没有意义，但这样可以消除叶节点对象和支节点对象在抽象层次上的区别，他们具有完全一致的接口
    @Override
    public void add(Component component) {
        System.out.println("cannot add to a leaf ..");
    }

    @Override
    public void remove(Component component) {
        System.out.println("cannot remove from a leaf");
    }
    //叶节点的具体方法，此处是显示其名称和级别
    @Override
    public void display(int depth) {
        StringBuilder b = new StringBuilder();
        for (int i = 0;i < depth;i++){
            b.append("-");
        }
        System.out.println(b.toString() + name);    }
}
