package org.java;

import org.java.BinaryTrees.TreeNode;

public class MorisTraversal {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        morrisTraversal(root);
    }

    private static void morrisTraversal(TreeNode root) {
        TreeNode curr = root;
        while (curr != null) {
            // if left is null collect and move right
            if (curr.left == null) {
                System.out.print(curr.value + " ");
                curr = curr.right;
            } else {
                TreeNode prev = curr.left;
                while (prev.right != null && prev.right != curr) {
                    prev = prev.right;
                }
                // at the end of right most node which next points to null so create thread
                if (prev.right == null) {
                    prev.right = curr;
                    curr = curr.left;
                } else {
                    // at the end of node which is attached to next with a thread
                    prev.right = null;
                    System.out.print(curr.value + " ");
                    curr = curr.right;
                }
            }
        }
    }
}
