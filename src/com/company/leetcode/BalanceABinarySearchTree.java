package com.company.leetcode;

import java.util.ArrayList;
import java.util.List;

public class BalanceABinarySearchTree {
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
    public static TreeNode balanceBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        dfs(root, list);

        if (list.isEmpty()) {
            return new TreeNode();
        }

        list.sort(Integer::compareTo);

        return createBalancedBST(list, 0, list.size() - 1);
    }

    private static void dfs(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        list.add(node.val);
        dfs(node.left, list);
        dfs(node.right, list);
    }

    private static TreeNode createBalancedBST(List<Integer> list, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = start + (end - start) / 2;

        TreeNode leftSubtree = createBalancedBST(list, start, mid - 1);
        TreeNode rightSubtree = createBalancedBST(list, mid + 1, end);

        return new TreeNode(list.get(mid), leftSubtree, rightSubtree);
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, null,
                new TreeNode(2, null,
                        new TreeNode(3, null, new TreeNode(4))));

        TreeNode treeNode = balanceBST(root);
        System.out.println(treeNode);
    }
}
