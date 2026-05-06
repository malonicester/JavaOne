package org.java.btree;


public class BTreeNode<T extends Comparable<T>> {
    T[] keys;
    int minDegree;
    BTreeNode<T>[] children;
    int keyCount;
    boolean isLeaf;

    @SuppressWarnings("unchecked")
    public BTreeNode(int minDegree, boolean isLeaf) {
        this.minDegree = minDegree;
        this.isLeaf = isLeaf;
        this.keys = (T[]) new Comparable[2 * minDegree - 1];  // Max keys = 2 * minDegree - 1
        this.children = new BTreeNode[2 * minDegree]; // Max children = 2 * minDegree
        this.keyCount = 0;
    }

    public void traverse() {
        int i;
        for (i = 0; i < keyCount; i++) {
            if (!isLeaf) {
                children[i].traverse();
            }
            System.out.print(keys[i] + " ");
        }
        if (!isLeaf) {
            children[i].traverse();
        }
    }


    public void insertNonFull(T key) {
        int i = keyCount - 1;
        if (isLeaf) {
            // Find the correct position to insert the key
            while (i >= 0 && keys[i].compareTo(key) > 0) {
                keys[i + 1] = keys[i];
                i--;
            }
            keys[i + 1] = key;
            keyCount++;
        } else {
            // Find the child that will have the new key
            while (i >= 0 && keys[i].compareTo(key) > 0) {
                i--;
            }
            i++;
            if (children[i].keyCount == 2 * minDegree - 1) { // If the child is full, split it
                splitChild(i, children[i]);
                if (keys[i].compareTo(key) < 0) {
                    i++;
                }
            }
            children[i].insertNonFull(key);
        }
    }


    // Function to split a full child
    public void splitChild(int childIndex, BTreeNode<T> fullChild) {
        BTreeNode<T> newChild = new BTreeNode<>(fullChild.minDegree, fullChild.isLeaf);
        newChild.keyCount = minDegree - 1;

        // Move last (minDegree - 1) keys from fullChild to newChild
        for (int j = 0; j < minDegree - 1; j++) {
            newChild.keys[j] = fullChild.keys[j + minDegree];
        }

        // Move child pointers (if fullChild is not a leaf)
        if (!fullChild.isLeaf) {
            for (int j = 0; j < minDegree; j++) {
                newChild.children[j] = fullChild.children[j + minDegree];
            }
        }

        fullChild.keyCount = minDegree - 1; // Reduce the number of keys in fullChild

        // Shift children of the current node (this) to make space for the new child
        for (int j = keyCount; j >= childIndex + 1; j--) {
            children[j + 1] = children[j];
        }
        children[childIndex + 1] = newChild;

        // Move the middle key up into this node
        for (int j = keyCount - 1; j >= childIndex; j--) {
            keys[j + 1] = keys[j];
        }
        keys[childIndex] = fullChild.keys[minDegree - 1];
        keyCount++;
    }
}
