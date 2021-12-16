package com.company.Leetcode;

import java.util.ArrayDeque;
import java.util.Queue;

public class SameTree {

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

    public boolean isSameTreeRecursive(TreeNode p, TreeNode q) {
        // p and q are both null
        if (p == null && q == null) return true;
        // one of p and q is null
        if (q == null || p == null) return false;
        if (p.val != q.val) return false;
        return isSameTreeRecursive(p.right, q.right) && isSameTreeRecursive(p.left, q.left);
    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (!isEqual(p, q)) {
            return false;
        }
        Queue<TreeNode> queue1 = new ArrayDeque<>();
        Queue<TreeNode> queue2 = new ArrayDeque<>();
        queue1.add(p);
        queue2.add(q);

        TreeNode current1;
        TreeNode current2;
        while (!queue1.isEmpty() || !queue2.isEmpty()) {
            current1 = queue1.poll();
            current2 = queue2.poll();

            if (!isEqual(current1, current2)) {
                return false;
            }

            if (!isEqual(current1.left, current2.left)) {
                return false;
            }

            if (current1.left != null) {
                queue1.add(current1.left);
            }

            if (current2.left != null) {
                queue2.add(current2.left);
            }

            if (!isEqual(current1.right, current2.right)) {
                return false;
            }

            if (current1.right != null) {
                queue1.add(current1.right);
            }

            if (current2.right != null) {
                queue2.add(current2.right);
            }
        }

        return true;
    }

    private static boolean isEqual(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) {
            return true;
        }

        if (node1 == null || node2 == null ) {
            return false;
        }

        if (node1.val != node2.val) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
//        TreeNode root1 = new TreeNode(1, new TreeNode(2), null);
//        TreeNode root2 = new TreeNode(1, null, new TreeNode(3));

//        TreeNode root1 = new TreeNode(1);
//        root1.left = new TreeNode(2);
//
//        TreeNode root2 = new TreeNode(1);
//        root2.left = null;
//        root2.right = new TreeNode(3);
        TreeNode root1 = new TreeNode();
        TreeNode root2 = new TreeNode();

        System.out.println(isSameTree(root1, root2));

    }
}
