package org.java;


import org.java.btree.BTree;

import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        String url = "sdjfaljsd";
        BTree<Integer> tree = new BTree<>(3); // Order 3 B-Tree
        Integer[] keys = {10, 20, 5, 6, 12, 30, 7, 17, 50, 60, 70, 80, 90};
        for (Integer key : keys) {
            tree.insert(key);
        }
        System.out.println("B-Tree traversal:");
        tree.traverse();

        Main main = new Main();

        CompletableFuture<Void> exceptionally = CompletableFuture.supplyAsync(() -> main.getValue()).exceptionally((ex) -> {
                        return "Exception Occurred in GetValue";
                })
                .thenAccept((value) -> main.exceptionMethod(value))
                .exceptionally((ex) -> {
                    System.out.println("Exception Occurred " + ex.getLocalizedMessage());
                    return null;
                });
        Void join = exceptionally.join();
        System.out.println("Completed");
    }

    public String getValue() {
        if(true) {
            throw new IllegalArgumentException("fnaskdfn");
        }
        return "A New Value";
    }

    public void exceptionMethod(String value) {
        throw new IllegalArgumentException("Exception Thrown sdfadsf " + value);
    }
}