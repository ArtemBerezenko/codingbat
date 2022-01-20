package com.company.Leetcode;

public class DiameterOfBinaryTree {

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

    static int result = 0;
    public static int diameterOfBinaryTree(TreeNode root) {
        diameter(root);
        return result;
    }

    private static int diameter(TreeNode node) {
        if (node == null) {
            return 0;
        } else {
            int l = diameter(node.left);
            int r = diameter(node.right);
            result = Math.max(result, l + r);
            return Math.max(l, r) + 1;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1,
                new TreeNode(2),
                null
        );

        System.out.println(diameterOfBinaryTree(root));

    }
}
