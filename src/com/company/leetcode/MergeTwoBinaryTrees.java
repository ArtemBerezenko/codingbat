package com.company.leetcode;

public class MergeTwoBinaryTrees {

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

    public static TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return null;
        }

        TreeNode result = new TreeNode();

        if (root1 != null && root2 != null) {
            result.val = root1.val + root2.val;
            result.left = mergeTrees(root1.left, root2.left);
            result.right = mergeTrees(root1.right, root2.right);
        }

        if (root1 == null) {
            result = root2;
        }
        if (root2 == null) {
            result = root1;
        }

        return result;

    }

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(1,
                new TreeNode(3, new TreeNode(5), null),
                new TreeNode(2)
        );
        TreeNode root2 = new TreeNode(2,
                new TreeNode(1, null, new TreeNode(4)),
                new TreeNode(3, null, new TreeNode(7))
        );

        TreeNode treeNode = mergeTrees(root1, root2);
        System.out.println(treeNode);

    }
}
