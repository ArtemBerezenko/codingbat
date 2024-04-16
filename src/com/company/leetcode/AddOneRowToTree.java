package com.company.leetcode;

public class AddOneRowToTree {
    
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

    public static TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (depth == 1) {
            TreeNode n = new TreeNode(val);
            n.left = root;
            return n;
        }
        dfs(root, val, 1, depth);
        return root;
    }

    public static void dfs(TreeNode node, int val, int depth, int n) {
        if (node == null) {
            return;
        }
        if (depth == n - 1) {
            TreeNode temp = node.left;
            node.left = new TreeNode(val);
            node.left.left = temp;
            temp = node.right;
            node.right = new TreeNode(val);
            node.right.right = temp;
        } else {
            dfs(node.left, val, depth + 1, n);
            dfs(node.right, val, depth + 1, n);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4,
                new TreeNode(2, new TreeNode(3), new TreeNode(1)),
                new TreeNode(6, new TreeNode(5), null)
        );
        System.out.println(addOneRow(root, 1, 2));
    }
}
