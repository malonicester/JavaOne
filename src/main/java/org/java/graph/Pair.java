package org.java.graph;

public class Pair<K extends Comparable<K>,V extends Comparable<V>> implements Comparable<Pair<K,V>> {

    @Override
    public int compareTo(Pair<K, V> o) {
        if(!this.key.equals(o.key)) {
            return key.compareTo(o.key);
        }
        return this.value.compareTo(o.value);
    }

    public K key;
    public V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public static <K extends Comparable<K>,V extends Comparable<V>> Pair<K,V> createPair(K k, V v){
        return new Pair<>(k,v);
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Pair{" +
                "key=" + key +
                ", value=" + value +
                '}';
    }
}
