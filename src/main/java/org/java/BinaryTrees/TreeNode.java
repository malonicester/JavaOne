package org.java.BinaryTrees;

public class TreeNode implements Comparable<TreeNode> {
    public int value;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(int value) {this.value = value;}
    public TreeNode(int value, TreeNode left, TreeNode right) {}

    @Override
    public int compareTo(TreeNode o) {
        return 0;
    }
}
