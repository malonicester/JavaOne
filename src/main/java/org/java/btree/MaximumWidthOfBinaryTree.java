package org.java.btree;

import org.java.BinaryTrees.TreeNode;
import org.java.graph.Pair;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class MaximumWidthOfBinaryTree {
    public static void main(String[] args) {

    }

    public static int maximumWidth(TreeNode node) {
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        queue.offer(new Pair<>(node, 0));
        int maxWidth = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            int minIndex = queue.peek().value;
            int first = 0, last = 0;
            for (int i = 0; i < size; i++) {
                Pair<TreeNode, Integer> pair = queue.poll();
                int index = pair.value - minIndex;
                if (i == 0) first = index;
                if (i == size - 1) last = index;

                if (pair.getKey().left != null) {
                    queue.offer(new Pair<>(pair.getKey().left, 2 * index + 1));
                }
                if (pair.getKey().right != null) {
                    queue.offer(new Pair<>(pair.getKey().left, 2 * index + 2));
                }
            }
            maxWidth = Math.max(maxWidth, last - first + 1);
        }
        return maxWidth;
    }


    public static int maximumWidth2(TreeNode node) {
        int maximumWidth = 0;
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();

        queue.offer(new Pair<>(node, 0));

        while (!queue.isEmpty()) {
            Pair<TreeNode, Integer> pair = queue.peek();
            int index = pair.getValue();
            int size = queue.size(); // size of current level
            int first = 0, last = 0;
            for (int i = 0; i < size; i++) {
                Pair<TreeNode, Integer> currentPair = queue.poll();
                int currentIndex = currentPair.getValue() - index;
                TreeNode treeNode = currentPair.getKey();
                if (i == 0) {
                    first = currentIndex;
                }
                if (i == size - 1) {
                    last = currentIndex;
                }
                if (treeNode.left != null) {
                    queue.offer(new Pair<>(treeNode.left, 2 * currentIndex + 1));
                }

                if (treeNode.right != null) {
                    queue.offer(new Pair<>(treeNode.right, 2 * currentIndex + 2));
                }
                maximumWidth = Math.max(last - first + 1, maximumWidth);
            }
        }
        return maximumWidth;
    }
}
