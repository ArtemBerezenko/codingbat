package com.company.Leetcode;

import java.util.ArrayList;
import java.util.List;

public class PathSumII {

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


    public static List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        pathSum(root, result, new ArrayList<>(), targetSum);
        return result;
    }

    public static void pathSum(TreeNode root, List<List<Integer>> result, List<Integer> list, int targetSum) {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null && targetSum == root.val) {
            list.add(root.val);
            result.add(new ArrayList<>(list));
            list.remove(list.size() - 1);

        } else {
            list.add(root.val);
            pathSum(root.left, result, list, targetSum - root.val);
            pathSum(root.right, result, list, targetSum - root.val);
            list.remove(list.size() - 1);
        }
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(5,
                new TreeNode(4, new TreeNode(11, new TreeNode(7), new TreeNode(2)), null),
                new TreeNode(8, new TreeNode(13), new TreeNode(4, new TreeNode(5), new TreeNode(1)))
        );

        System.out.println(pathSum(root, 22));

    }
}
