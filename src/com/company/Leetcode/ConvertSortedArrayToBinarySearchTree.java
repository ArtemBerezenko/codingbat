package com.company.Leetcode;

public class ConvertSortedArrayToBinarySearchTree {

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

    public static TreeNode sortedArrayToBST(int[] nums) {
        int l = 0;
        int h = nums.length - 1;

        return toBST(nums, l, h);
    }

    private static TreeNode toBST(int[] nums, int l, int h) {
        if (l > h) {
            return null;
        }

        int mid = l + (h - l) / 2;
        return new TreeNode(nums[mid], toBST(nums, l, mid - 1), toBST(nums, mid + 1, h));
    }


    public static void main(String[] args) {
        System.out.println(sortedArrayToBST(new int[] {0,1,2,3,4,5}));
    }
}
