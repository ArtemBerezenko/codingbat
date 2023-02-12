package com.company.leetcode;

public class BalancedBinaryTree {

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

    public static boolean isBalanced(TreeNode root) {
        return isBalanced(root, 0) != -1;
    }

    private static int isBalanced(TreeNode node, int count) {
        if (node == null) {
            return count;
        }
        count++;
        int leftCount = isBalanced(node.left, count);
        int rightCount = isBalanced(node.right, count);
        if (leftCount == -1 || rightCount == -1) return -1;
        if (Math.abs(leftCount - rightCount) > 1) return -1;
        return Math.max(leftCount, rightCount);
    }


    public static void main(String[] args) {
//        TreeNode rootLeft = new TreeNode(2, new TreeNode(3), new TreeNode(4));
//        TreeNode rootRight = new TreeNode(2, new TreeNode(4), new TreeNode(3));
//        TreeNode root = new TreeNode(1, rootLeft, rootRight);

        TreeNode root = new TreeNode(3,
                new TreeNode(9, new TreeNode(15), new TreeNode(7)),
                new TreeNode(20)
        );

        System.out.println(isBalanced(root));

    }
}
