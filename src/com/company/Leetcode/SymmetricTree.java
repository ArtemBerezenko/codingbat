package com.company.Leetcode;

public class SymmetricTree {

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

    public static boolean isSymmetric(TreeNode root) {
        return isSymmetric(root.left, root.right);
    }

    private static boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null)  {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        if (left.val != right.val) {
            return false;
        }
        return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
    }


    public static void main(String[] args) {
//        TreeNode rootLeft = new TreeNode(2, new TreeNode(3), new TreeNode(4));
//        TreeNode rootRight = new TreeNode(2, new TreeNode(4), new TreeNode(3));
//        TreeNode root = new TreeNode(1, rootLeft, rootRight);

        TreeNode rootLeft = new TreeNode(2, null,  new TreeNode(3));
        TreeNode rootRight = new TreeNode(2, null, new TreeNode(3));
        TreeNode root = new TreeNode(1, rootLeft, rootRight);

        System.out.println(isSymmetric(root));

    }

}
