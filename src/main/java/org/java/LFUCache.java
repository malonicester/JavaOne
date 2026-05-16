package org.java;

import java.util.*;

class LFUCache {

    private Node head;

    private Node tail;

    private final Map<Integer, Integer> cache;

    private final TreeMap<Integer, LinkedHashSet<Integer>> lruMap;

    private final int capacity;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.head = new Node(-1, -1);
        this.tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
        this.cache = new HashMap<>();
        this.lruMap = new TreeMap<>();
    }

    public int get(int key) {
        if (this.cache.containsKey(key)) {
            process(key);
            return cache.get(key);
        }
        return -1;
    }

    public void put(int key, int value) {
        this.cache.put(key,value);
        process(key);
        delete();
    }

    private void process(int key) {

    }

    private void delete() {

    }

    private static class Node {
        Node next;
        Node prev;
        int value;
        int key;
        int count;
        long nanos;

        public Node(int key, int val) {
            this.key = key;
            this.value = val;
            this.count = 0;
//            this.nanos = System.nanoTime();
        }
    }

    public static void main(String[] args) {
        LFUCache lfuCache = new LFUCache(2);
        lfuCache.put(1, 1);
        lfuCache.put(2, 2);
        System.out.println(lfuCache.get(1));
        lfuCache.put(3, 3);
        System.out.println(lfuCache.get(2));
        System.out.println(lfuCache.get(3));
        lfuCache.put(4, 4);
        System.out.println(lfuCache.get(1));
        System.out.println(lfuCache.get(3));
        System.out.println(lfuCache.get(4));
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
