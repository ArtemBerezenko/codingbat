package com.company.leetcode;

public class MaximumDifferenceBetweenNodeAndAncestor {
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

    public static int maxAncestorDiff(TreeNode root) {
        return visit(root, root.val, root.val);
    }
    
    private static int visit(TreeNode node, int max, int min) {
        if (node == null) {
            return max - min;
        }
        max = Math.max(max, node.val);
        min = Math.min(min, node.val);
        int left = visit(node.left, max, min);
        int right = visit(node.right, max, min);
        return Math.max(left, right);
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(3,
                new TreeNode(5,
                        new TreeNode(6),
                        new TreeNode(2, new TreeNode(7), new TreeNode(4))
                ),
                new TreeNode(1,
                        new TreeNode(9),
                        new TreeNode(8)
                )
        );
        System.out.println(maxAncestorDiff(treeNode));
    }
}
