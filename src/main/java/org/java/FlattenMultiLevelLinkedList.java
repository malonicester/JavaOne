package org.java;

public class FlattenMultiLevelLinkedList {
    public static void main(String[] args) {

    }


    private static Node flattenMultiLevelLinkedList(Node root) {
        if (root == null) return null;
        Node node = root;
        while (node != null) {
            Node child = node.child;
            if (child != null) {
                Node end = child;
                Node next = node.next;
                while (end.next != null) {
                    end = end.next;
                }
                node.next = child;
                child.prev = node;
                end.next = next;
                next.prev = end;
            }
            node.child = null;
            node = node.next;
        }
        return root;
    }

    private static class Node {
        Node next;
        Node child;
        Node prev;
        int value;

        public Node(int value) {
            this.value = value;
        }
    }
}
