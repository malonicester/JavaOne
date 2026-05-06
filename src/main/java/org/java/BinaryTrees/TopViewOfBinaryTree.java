package org.java.BinaryTrees;

import com.sun.source.tree.Tree;
import org.java.graph.Pair;

import java.util.*;

public class TopViewOfBinaryTree {
    public static void main(String[] args) {

    }

    private static List<Integer> topViewOfBinaryTree(TreeNode root) {
        Map<Integer, Integer> topViewMap = new TreeMap<>();
        Queue<Pair<TreeNode, Pair<Integer, Integer>>> queue = new LinkedList<>();
        queue.offer(Pair.createPair(root, Pair.createPair(0, 0)));
        while (!queue.isEmpty()) {
            Pair<TreeNode, Pair<Integer, Integer>> pair = queue.poll();
            TreeNode node = pair.getKey();
            Pair<Integer, Integer> rowCol = pair.getValue();
            int row = rowCol.getKey();
            int col = rowCol.getValue();
            if (node.left != null) {
                queue.offer(Pair.createPair(node.left, Pair.createPair(row + 1, col - 1)));
            }
            if (node.right != null) {
                queue.offer(Pair.createPair(node.left, Pair.createPair(row + 1, col + 1)));
            }

            if(!topViewMap.containsKey(col)) {
                topViewMap.put(col,node.value);
            }
        }
        return new ArrayList<>(topViewMap.values());
    }
}
