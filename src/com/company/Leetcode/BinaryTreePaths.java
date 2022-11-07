package com.company.Leetcode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {

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

    public static List<String> binaryTreePaths(TreeNode root) {
        List<String> resultList = new ArrayList<>();
        binaryTreePaths(root, "", resultList);
        return resultList;
    }

    public static void binaryTreePaths(TreeNode root, String resultStr, List<String> resultList) {

        if (root.left == null && root.right == null) {
            resultList.add(resultStr + root.val);
        }

        if (root.left != null) {
            binaryTreePaths(root.left, resultStr + root.val + "->", resultList);
        }

        if (root.right != null) {
            binaryTreePaths(root.right, resultStr + root.val + "->", resultList);
        }
    }

    public static void main(String[] args) {
        //1,5,2,4,3
        List<String> strings = binaryTreePaths(new TreeNode(1, new TreeNode(2, null,  new TreeNode(5)), new TreeNode(3)));
        System.out.println(strings);
    }

}
