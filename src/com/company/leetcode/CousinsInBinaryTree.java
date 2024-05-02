package com.company.leetcode;

public class CousinsInBinaryTree {
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

    static int recordedDepth = -1;
    static boolean isCousin = false;

    public static boolean isCousins(TreeNode root, int x, int y) {
        dfs(root, 0, x, y);
        return isCousin;
    }

    private static boolean dfs(TreeNode node, int depth, int x, int y) {

        if (node == null) {
            return false;
        }

        if (recordedDepth != -1 && depth > recordedDepth) {
            return false;
        }

        if (node.val == x || node.val == y) {
            if (recordedDepth == -1) {
                recordedDepth = depth;
            }
            return recordedDepth == depth;
        }

        boolean left = dfs(node.left, depth + 1, x, y);
        boolean right = dfs(node.right, depth + 1, x, y);


        if (left && right && recordedDepth != depth + 1) {
            isCousin = true;
        }
        return left || right;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1,
                new TreeNode(2, new TreeNode(4), null),
                new TreeNode(3, new TreeNode(5), null)
        );
        System.out.println(isCousins(root, 5, 4));

    }
}
