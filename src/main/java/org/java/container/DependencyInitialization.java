package org.java.container;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class DependencyInitialization {

    static Map<String, Pair<Class<?>, Object>> pairMap = new ConcurrentHashMap<>();

    public static void initialize(){
       
    }

    static class Pair<K,V>{
        K key;
        V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}
