package org.java.BinaryTrees;

public class BalancedTrees {
    public static boolean isBalanced(TreeNode root) {
        return heightOfTrees(root) != -1;
    }

    private static int heightOfTrees(TreeNode node) {
        if (node == null) return 0;
        int leftHalf = heightOfTrees(node.left);
        if (leftHalf == -1) return -1;
        int rightHalf = heightOfTrees(node.right);
        if (rightHalf == -1) return -1;
        if (Math.abs(leftHalf - rightHalf) > 1) return -1;
        return 1 + Math.max(leftHalf, rightHalf);
    }
}
