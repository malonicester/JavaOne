package org.java;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    int capacity;

    Map<Integer, Node> nodeMap = new HashMap<>();

    Node head = new Node(-1, -1);

    Node tail = new Node(-1, -1);

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (nodeMap.containsKey(key)) {
            Node node = nodeMap.get(key);
            addToHead(node);
            return node.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (nodeMap.containsKey(key)) {
            Node node = nodeMap.get(key);
            node.value = value;
            addToHead(node);
            return;
        }
        if (nodeMap.size() == this.capacity) {
            remove();
        }
        Node node = new Node(key, value);
        nodeMap.put(key, node);
        Node headNext = head.next;

        head.next = node;
        node.prev = head;
        node.next = headNext;
        headNext.prev = node;
    }

    private void remove() {
        if (head.next == tail) return;
        Node nodeToRemoved = tail.prev;
        Node prev = nodeToRemoved.prev;
        prev.next = tail;
        tail.prev = prev;
        this.nodeMap.remove(nodeToRemoved.key);
        nodeToRemoved.next = null;
        nodeToRemoved.prev = null;
    }

    private void addToHead(Node node) {
        if (node.prev == head) return;
        Node headNext = head.next;
        Node next = node.next;
        Node prev = node.prev;
        prev.next = next;
        next.prev = prev;

        head.next = node;
        node.next = headNext;
        headNext.prev = node;
        node.prev = head;
    }

    private static class Node {
        Node next;
        Node prev;
        int key;
        int value;

        public Node(int key, int value) {
            this.value = value;
            this.key = key;
        }

    }
}
