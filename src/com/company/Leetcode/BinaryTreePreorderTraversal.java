package com.company.Leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePreorderTraversal {

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

    public static List<Integer> preorderTraversal(TreeNode root) {
        return preorderTraversal(root, new ArrayList<>());
    }

    public static List<Integer> preorderTraversal(TreeNode node, List<Integer> list) {
        if (node != null) {
            list.add(node.val);
            preorderTraversal(node.left, list);
            preorderTraversal(node.right, list);
        }
        return list;
    }

    public static List<Integer> preorderTraversalIterative(TreeNode root) {
        List<Integer> resultList = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode current = stack.pop();
            if (current != null) {
                resultList.add(current.val);

                if (current.right != null) {
                    stack.push(current.right);
                }

                if (current.left != null) {
                    stack.push(current.left);
                }

            }
        }
        return resultList;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null));
        TreeNode root1 = null;


        display(preorderTraversalIterative(root1));

    }

    private static void display(List<Integer> nums) {
        for (Integer num : nums) {
            System.out.print(num + ", ");
        }
        System.out.println(" ");
    }
}
