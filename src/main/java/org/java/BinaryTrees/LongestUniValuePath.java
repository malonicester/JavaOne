package org.java.BinaryTrees;

import org.java.graph.Pair;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class LongestUniValuePath {

    private int longestUniValue(TreeNode node) {
        int max = Integer.MIN_VALUE;
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();

        queue.offer(new Pair<>(node, 1));

        while (!queue.isEmpty()) {
            Pair<TreeNode, Integer> pair = queue.poll();
            TreeNode key = pair.getKey();
            int value = pair.value;
            if (key.left != null) {
                if (key.left.value == key.value) {
                    value++;
                }
            }
            if (key.right != null) {
                if (key.right.value == key.value) {
                    value++;
                }
            }
            if (key.left != null) {
                queue.offer(new Pair<>(key.left, value));
            }

            if (key.right != null) {
                queue.offer(new Pair<>(key.right, value));
            }
            max = Math.max(max,value);
        }
        return max;
    }
}
