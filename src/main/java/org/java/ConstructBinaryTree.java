package org.java;

import org.java.BinaryTrees.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTree {
    public static void main(String[] args) {

    }

    private static TreeNode constructBinaryTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inOrderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inOrderMap.put(inorder[i], i);
        }
        return construct(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    private static TreeNode construct(int[] preorder, int[] inorder, int preStart, int preEnd, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd) return null;
        int root = preorder[preStart];
        TreeNode node = new TreeNode(preorder[preStart]);
        int inOrderRootIndex = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == root) {
                inOrderRootIndex = i;
                break;
            }
        }

        int countOfLeftSubTreeNodes = inOrderRootIndex - inStart;

        node.left = construct(preorder, inorder, preStart + 1, preStart + countOfLeftSubTreeNodes, inStart, inOrderRootIndex - 1);
        node.right = construct(preorder, inorder, preStart + countOfLeftSubTreeNodes + 1, preEnd, inOrderRootIndex + 1, inEnd);
        return node;
    }

    private static TreeNode constructFromInorderAndPreOrder(int[] inorder, int[] postorder, int postStart, int postEnd, int inStart, int inEnd) {
        if(postStart > postEnd || inStart > inEnd) return null;
        int root = postorder[postStart];
        int inOrderRootIndex = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == root) {
                inOrderRootIndex = i;
                break;
            }
        }

        int countOfRightNodes = inEnd - inOrderRootIndex;
        int countOfLeftNodes = inOrderRootIndex - inStart;
        TreeNode node = new TreeNode(root);



        node.left = constructFromInorderAndPreOrder(
                inorder,
                postorder,
                postStart,
                postStart + countOfLeftNodes - 1,
                inStart,
                inOrderRootIndex - 1
        );


        node.right = constructFromInorderAndPreOrder(
                inorder,
                postorder,
                postEnd - countOfRightNodes,
                postEnd - 1,
                inOrderRootIndex + 1,
                inEnd
        );

        return node;
    }
}

