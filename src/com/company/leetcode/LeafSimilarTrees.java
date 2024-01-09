package com.company.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeafSimilarTrees {

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

    public static boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> first = new ArrayList<>();
        List<Integer> second = new ArrayList<>();
        
        visit(root1, first);
        visit(root2, second);
        
        return first.equals(second);
    }

    public static void visit(TreeNode node, List<Integer> list) {
        if (node != null) {
            visit(node.left, list);
            visit(node.right, list);
            if (node.left == null && node.right == null) {
                list.add(node.val);
            }
        }
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
        TreeNode treeNode2 = new TreeNode(3,
                new TreeNode(5,
                        new TreeNode(6),
                        new TreeNode(7)
                ),
                new TreeNode(1,
                        new TreeNode(4),
                        new TreeNode(2,  new TreeNode(9),  new TreeNode(8))
                )
        );
        System.out.println(leafSimilar(treeNode, treeNode2));
    }
}
