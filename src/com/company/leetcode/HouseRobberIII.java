package com.company.leetcode;

import java.util.HashMap;
import java.util.Map;


public class HouseRobberIII {

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
    private static Map<TreeNode, Integer> memo = new HashMap<>();

    public static int rob(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (memo.containsKey(root)) {
            return memo.get(root);
        }

        int current = root.val;
        if (root.left != null) {
            current += rob(root.left.left) + rob(root.left.right);
        }
        if (root.right != null) {
            current += rob(root.right.left) + rob(root.right.right);
        }


        int skip = rob(root.left) + rob(root.right);
        int result = Math.max(current, skip);

        memo.put(root, result);

        return result;
    }
    

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3,
                new TreeNode(2, null, new TreeNode(3)),
                new TreeNode(3, null, new TreeNode(1))
        );
        System.out.println(rob(root));
    }

}
