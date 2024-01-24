package com.company.leetcode;

import java.util.HashMap;
import java.util.Map;

public class PseudoPalindromicPathsInABinaryTree {
    
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

    static Map<Integer, Integer> map = new HashMap<>();
    static int result = 0;
    
    public static int pseudoPalindromicPaths (TreeNode root) {
        dfs(root);
        return result;
    }
    
    private static void dfs(TreeNode node) {
        if (node != null) {
            map.put(node.val, map.getOrDefault(node.val, 0) + 1);

            if (node.left == null && node.right == null) {
                long odds = map.values().stream().filter(v -> v % 2 != 0).count();
                if (odds <= 1) {
                    result++;
                }
            }
            
            dfs(node.left);
            dfs(node.right);

            if(map.get(node.val) > 0){
                map.put(node.val, map.get(node.val) - 1);
            }
        }
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(2,
                new TreeNode(3, new TreeNode(3), new TreeNode(1)),
                new TreeNode(1, null, new TreeNode(1))
        );
        
        System.out.println(pseudoPalindromicPaths(root));

    }
}
