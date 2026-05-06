package org.java.BinaryTrees;

public class MaximumPathSum {

    private Integer max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        if (root == null) return 0;
        int left = Math.max(0, maxPathSum(root.left));
        int right = Math.max(0, maxPathSum(root.right));
        max = Math.max(max, left + right + root.value);
        return Math.max(left,right) + root.value;
    }
}
