package com.company.leetcode;

import java.util.ArrayList;
import java.util.List;

public class AverageOfLevelsInBinaryTree {

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

    public static List<Double> averageOfLevels(TreeNode root) {
        int treeHeight = height(root);
        List<Double> result = new ArrayList<>();
        int[] count = new int[treeHeight];
        double[] sum = new double[treeHeight];

        averageOfLevels(root, sum, count, 0);

        for (int i = 0; i < treeHeight; i++) {
            result.add(sum[i]/count[i]);
        }

        return result;
    }

    private static int height(TreeNode node) {
        if (node == null) {
            return 0;
        } else {
            int l = height(node.left);
            int r = height(node.right);
            return Math.max(l, r) + 1;
        }
    }

    private static void averageOfLevels(TreeNode node, double[] sum, int[] count, int level) {
        if (node == null) {
            return;
        }

        count[level]++;
        sum[level] += node.val;

        averageOfLevels(node.left, sum, count, level + 1);
        averageOfLevels(node.right, sum, count, level + 1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3,
                new TreeNode(9, new TreeNode(15), new TreeNode(7)),
                new TreeNode(20, new TreeNode(30), null)
        );

        System.out.println(averageOfLevels(root));

    }
}
