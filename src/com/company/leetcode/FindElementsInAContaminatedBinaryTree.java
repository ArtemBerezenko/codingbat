package com.company.leetcode;

import java.util.HashSet;
import java.util.Set;

public class FindElementsInAContaminatedBinaryTree {

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

//    If treeNode.val has a value x and treeNode.left != null, then treeNode.left.val == 2 * x + 1
//    If treeNode.val has a value x and treeNode.right != null, then treeNode.right.val == 2 * x + 2

    static class FindElements {
        private static Set<Integer> set = new HashSet<>();

        public FindElements(TreeNode root) {
            dfs(root, 0);
        }

        public boolean find(int target) {
            return set.contains(target);
        }

        private static void dfs(TreeNode root, int value) {
            if (root != null) {
                set.add(value);
                dfs(root.left, value * 2 + 1);
                dfs(root.right, value * 2 + 2);
            }
        }
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(-1, null, new TreeNode(-1));
        int[] target = new int[]{1, 2};
        FindElements obj = new FindElements(root);
        for (int t: target) {
            System.out.println(obj.find(t));
        }
    }
}
