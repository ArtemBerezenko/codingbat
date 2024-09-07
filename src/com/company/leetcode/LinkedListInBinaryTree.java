package com.company.leetcode;

public class LinkedListInBinaryTree {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

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


    public static boolean isSubPath(ListNode head, TreeNode root) {
        if (root == null) return false;
        return checkPath(head, root);
    }

    private static boolean checkPath(ListNode head, TreeNode node) {
        if (node == null) {
            return false;
        }
        if (dfs(head, node)) {
            return true;
        }

        return checkPath(head, node.left) || checkPath(head, node.right);
    }

    public static boolean dfs(ListNode head, TreeNode root) {
        if (head == null) {
            return false;
        }
        if (root == null) {
            return false;
        }
        if (head.val != root.val) {
            return false;
        }

        return dfs(head.next, root.left) || dfs(head.next, root.right);

    }

    public static void main(String[] args) {
        ListNode head = new ListNode(4,new ListNode(2, new ListNode(8)));
        TreeNode treeNode = new TreeNode(1,
                new TreeNode(4, null, new TreeNode(2, new TreeNode(1), null)),
                new TreeNode(4, new TreeNode(2, new TreeNode(6), new TreeNode(8, new TreeNode(1), new TreeNode(3))), null));

        System.out.println(isSubPath(head, treeNode));
    }
}
