package com.company.leetcode;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryFromInorderAndPostorderTraversal {
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

    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        index = postorder.length - 1;
        return build(populateMap(inorder), postorder, 0, index);
    }

    private static Map<Integer, Integer> populateMap(int[] treeArray) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < treeArray.length; i++) {
            map.put(treeArray[i], i);
        }
        return map;
    }
    

    private static TreeNode build(Map<Integer, Integer> map, int[] postorder, int start, int end) {
        if (start > end)
            return null;

        int curr = postorder[index];
        int i = map.get(curr);
        index--;
        TreeNode root = new TreeNode(curr);
        root.right = build(map, postorder, i + 1, end);
        root.left = build(map, postorder, start, i - 1);

        return root;
    }

    public static void main(String[] args) {
        TreeNode treeNode = buildTree(new int[]{9, 3, 15, 20, 7}, new int[]{9, 15, 7, 20, 3});
        System.out.println(treeNode);
    }
}
