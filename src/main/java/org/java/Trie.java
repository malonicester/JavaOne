package org.java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Trie {

    private final TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            node.children.computeIfAbsent(ch, (c) -> new TrieNode());
            node = node.children.get(ch);
        }
        node.isEndOfWord = true;
    }

    private TrieNode traverse(String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            if (!node.children.containsKey(ch)) {
                return null;
            }
            node = node.children.get(ch);
        }
        return node;
    }

    public boolean startWith(String prefix) {
        return traverse(prefix) != null;
    }

    public List<String> suggestion(String prefix) {
        List<String> list = new ArrayList<>();
        TrieNode node = traverse(prefix);
        if (node == null) return list;
        dfs(node, prefix, list);
        return list;
    }

    private void dfs(TrieNode node, String currentWord, List<String> result) {
        if (node.isEndOfWord) {
            result.add(currentWord);
        }
        for (char ch : node.children.keySet()) {
            dfs(node.children.get(ch), currentWord + ch, result);
        }
    }

    private static class TrieNode {
        private final Map<Character, TrieNode> children = new HashMap<>();
        boolean isEndOfWord;
    }

    public static void main(String[] args) {

        Trie trie = new Trie();

        String word1 = "cat";
        String word2 = "car";
        String word3 = "cabbage";
        String word4 = "carbohydrate";
        trie.insert(word1);
        trie.insert(word2);
        trie.insert(word3);
        trie.insert(word4);

        System.out.println(trie.suggestion("car"));
    }
}
