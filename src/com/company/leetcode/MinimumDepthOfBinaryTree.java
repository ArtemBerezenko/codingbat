package com.company.leetcode;

public class MinimumDepthOfBinaryTree {

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

    public static int minDepth(TreeNode root) {
        return minHeight(root);
    }

    private static int minHeight(TreeNode node) {
        if (node == null) {
            return 0;
        } else if (node.left == null) {
            return 1 + minDepth(node.right);
        } else if (node.right == null) {
            return 1 + minDepth(node.left);
        } else {
            int l = minHeight(node.left);
            int r = minHeight(node.right);
            return Math.min(l, r) + 1;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2,
                null,
                new TreeNode(3, null, new TreeNode(4, null, new TreeNode(5, null, new TreeNode(6))))
        );

        System.out.println(minDepth(root));

    }
}
