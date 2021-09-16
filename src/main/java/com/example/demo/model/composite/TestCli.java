package com.example.demo.model.composite;

public class TestCli {
    public static void main(String[] args) {
        //生成树根root，根上长出两叶LeafA 和 LeafB
        Composite root = new Composite("root");
        root.add(new Leaf("Leaf A"));
        root.add(new Leaf("Leaf B"));

        //根上长出分支CompositeX，分支上也有两叶 LeafXA ，LeafXB
        Composite comp = new Composite("Composite X");
        comp.add(new Leaf("Leaf XA"));
        comp.add(new Leaf("Leaf XB"));

        root.add(comp);

        //在Composite X 上再长出分支Composite XY，分支上也有LeafXYA 和 LeafXYB
        Composite compXY = new Composite("Composite XY");
        compXY.add(new Leaf("CompositeXYA"));
        compXY.add(new Leaf("CompositeXYB"));

        comp.add(compXY);

        root.add(new Leaf("Leaf C"));

        Leaf leaf =new Leaf("Leaf D");
        root.add(leaf);
        root.remove(leaf);

        //显示大树的样子
        root.display(1);
    }
}
