package com.company.Leetcode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeInorderTraversal {

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

    public static List<Integer> inorderTraversal(TreeNode root) {
        return traversal(root, new ArrayList<>());
    }

    private static List<Integer> traversal(TreeNode root, List<Integer> list) {
        if (root != null) {
            traversal(root.left, list);
            list.add(root.val);
            traversal(root.right, list);
        }
        return list;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null));
        List<Integer> list = inorderTraversal(treeNode);
        System.out.println(list);
    }
}
