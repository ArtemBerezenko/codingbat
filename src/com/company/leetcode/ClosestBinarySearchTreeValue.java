package com.company.leetcode;

public class ClosestBinarySearchTreeValue {
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

    private static double closest = Integer.MAX_VALUE;
    private static int result = -1;

    public static int closestValue(TreeNode root, double target) {
        dfs(root, target);
        return result;
    }

    private static void dfs(TreeNode root, double target) {
        if (root != null) {
            dfs(root.left, target);
            double min = Math.min(Math.abs(root.val - target), closest);
            if (min < closest) {
                closest = min;
                result = root.val;
            }
            dfs(root.right, target);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4,
                new TreeNode(2, new TreeNode(1), new TreeNode(3)),
                new TreeNode(5)
        );

        System.out.println(closestValue(root, 3.714286
        ));
    }
}
