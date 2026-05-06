package org.java.BinaryTrees;

import java.util.Stack;

public class InOrderTraversal {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.left.right.right = new TreeNode(5);
        root.right = new TreeNode(6);
        printInOrder(root);
    }

    public static void printInOrder(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        stack.push(cur);
        while (!stack.isEmpty()) {
            if (cur == null) {
                TreeNode node = stack.peek();
                cur = stack.peek();
                if(cur.left == node){
                    cur = cur.right;
                }
            } else {
                if (cur.left != null) {
                    stack.push(cur.left);
                    cur = cur.left;
                } else {
                    System.out.print(cur.value + " ");
                    cur = cur.right;
                }
            }
        }
    }
}
