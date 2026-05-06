package org.java.btree;

public class BTree <T extends Comparable<T>>{
    private BTreeNode<T> root;
    private final int minDegree;

    public int getMinDegree() {
        return minDegree;
    }

    public BTree(int minDegree) {
        this.minDegree = minDegree;
        root = new BTreeNode<>(minDegree, true);
    }

    public void traverse() {
        if (root != null) root.traverse();
        System.out.println();
    }

    public void insert(T key) {
        if (root.keyCount == 2 * minDegree - 1) {
            BTreeNode<T> newRoot = new BTreeNode<>(minDegree, false);
            newRoot.children[0] = root;
            newRoot.splitChild(0, root);
            int i = (newRoot.keys[0].compareTo(key) < 0) ? 1 : 0;
            newRoot.children[i].insertNonFull(key);
            root = newRoot;
        } else {
            root.insertNonFull(key);
        }
    }
}
