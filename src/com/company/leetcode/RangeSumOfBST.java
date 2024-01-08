package com.company.leetcode;

public class RangeSumOfBST {
    
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
    static int ans;
    public static int rangeSumBST(TreeNode root, int low, int high) {
        ans = 0;
        dfs(root, low, high);
        return ans;
    }

    public static void dfs(TreeNode node, int low, int high) {
        if (node != null) {
            if (low <= node.val && node.val <= high)
                ans += node.val;
            if (low < node.val)
                dfs(node.left, low, high);
            if (node.val < high)
                dfs(node.right, low, high);
        }
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(10, 
                new TreeNode(5, 
                        new TreeNode(3), 
                        new TreeNode(7)
                ),
                new TreeNode(15, 
                        null,
                        new TreeNode(18)
                )
        );

        System.out.println(rangeSumBST(treeNode, 7, 15));
    }
}
