package com.company.leetcode;

/*
    The core idea is to process nodes in preorder to determine which
    nodes to create and use postorder to recognize when a subtree is complete.
    Since preorder always visits nodes in the order Root → Left → Right,
    each recursive call picks the next node from preorder and assigns it as the root of the current subtree.
    Meanwhile, since postorder follows Left → Right → Root, a subtree is fully processed
    when we encounter its root in postorder. To track this, we maintain an index posIndex that
    moves forward as nodes get finalized.
 */
public class ConstructBinaryTreeFromPreorderAndPostorderTraversal {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    private static int preIndex = 0;
    private static int postIndex = 0;

    public static TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        return helper(preorder, postorder);
    }

    private static TreeNode helper(int[] preorder, int[] postorder) {
        TreeNode root = new TreeNode(preorder[preIndex++]);

        if (root.val != postorder[postIndex]) {
            root.left = helper(preorder, postorder);
        }

        if (root.val != postorder[postIndex]) {
            root.right = helper(preorder, postorder);
        }

        postIndex++;
        return root;
    }

    public static void main(String[] args) {
        System.out.println(constructFromPrePost(new int[]{1,2,4,5,3,6,7}, new int[]{4,5,2,6,7,3,1}));
    }
}
