package com.company.leetcode;

public class RecoverTreeFromPreorderTraversal {

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

    static int index = 0;

    public static TreeNode recoverFromPreorder(String traversal) {
        return dfs(traversal, 0);
    }

    private static TreeNode dfs(String str, int depth) {
        if (index >= str.length()) {
            return null;
        }

        int currentDepth = getDepth(str.substring(index));

        if (currentDepth != depth) {
            return null;
        }
        index += currentDepth;
        String value = getValue(str.substring(index));
        index += value.length();
        TreeNode node = new TreeNode(Integer.parseInt(value));

        node.left = dfs(str, depth + 1);
        node.right = dfs(str, depth + 1);

        return node;
    }

    private static String getValue(String str) {
        int i = 0;
        var sb = new StringBuilder();
        while (i < str.length() && Character.isDigit(str.charAt(i))) {
            sb.append(str.charAt(i));
            i++;
        }
        return sb.toString();
    }

    private static int getDepth(String str) {
        int i = 0;
        while (i < str.length() && !Character.isDigit(str.charAt(i))) {
            i++;
        }
        return i;
    }

    public static void main(String[] args) {
        System.out.println(recoverFromPreorder("1-2--3--4-5--6--7"));
    }
}
