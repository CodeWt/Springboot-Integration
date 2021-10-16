package com.example.demo.model.composite.code0923;

public class Test {
    public static void main(String[] args) {
        DircNode root = new DircNode("root");
        DircNode dir1= new DircNode("dir-1");
        DircNode dir2= new DircNode("dir-2");
        Node leaf11 = new LeafNode("leaf11");
        Node leaf12 = new LeafNode("leaf12");
        Node leaf21 = new LeafNode("leaf21");
        Node leaf22 = new LeafNode("leaf22");
        root.addNode(dir1);
        root.addNode(dir2);
        dir1.addNode(leaf11);
        dir1.addNode(leaf12);
        dir2.addNode(leaf21);
        dir2.addNode(leaf22);
        tree(root,0);

    }
    static void tree(Node node,int depth){
        for (int i=0;i<depth;i++) System.out.print("--");
        node.printNode();
        if (node instanceof DircNode){
            for (Node n : ((DircNode) node).nodes){
                tree(n,depth + 1);
            }
        }
    }
}
