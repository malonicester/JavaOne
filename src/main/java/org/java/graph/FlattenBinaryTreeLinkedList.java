package org.java.graph;

import org.java.BinaryTrees.TreeNode;

public class FlattenBinaryTreeLinkedList {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(5);
        root.left = left;
        root.right = right;
        left.left = new TreeNode(3);
        left.right = new TreeNode(4);
        right.right = new TreeNode(6);

        TreeNode node = flattenBinaryTreesToLinkedList(root);
        while (node!= null) {
            System.out.print(node.value+" ");
            System.out.print(node.left+" ");

            node = node.right;
        }
    }

    private static TreeNode flattenBinaryTreesToLinkedList(TreeNode root) {
        TreeNode node = root;
        while (node != null) {
            TreeNode left = node.left;
            if (left != null) {
                TreeNode leftRightMost = left;
                while (leftRightMost.right != null) {
                    leftRightMost = leftRightMost.right;
                }
                TreeNode right = node.right;
                node.right = left;
                leftRightMost.right = right;
                node.left = null;
            }
            node = node.right;
        }
        return root;
    }
}
