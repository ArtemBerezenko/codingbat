//package com.company.microsoft;
//
//import com.company.leetcode.ConvertSortedArrayToBinarySearchTree;
//import com.company.leetcode.LeafSimilarTrees;
//
//public class FlipBinaryTree {
//    static class Tree {
//        public int x; 
//        public Tree l; 
//        public Tree r;
//
//
//        Tree() {
//        }
//
//        Tree(int val) {
//            this.x = val;
//        }
//
//        Tree(int val, Tree left, Tree right) {
//            this.x = val;
//            this.l = left;
//            this.r = right;
//        }
//    }
//    
//    public static Tree solution(Tree T, int leaf_id) {
//        Tree cur = find(T, leaf_id);
//        Tree p = cur;
//        while (cur != T) {
//            Tree gp = p.parent;
//            if (cur.l != null) {
//                cur.r = cur.l;
//            }
//            cur.l = p;
//            p.parent = cur;
//            if (p.left == cur) {
//                p.left = null;
//            } else if (p.right == cur) {
//                p.right = null;
//            }
//            cur = p;
//            p = gp;
//        }
//        leaf.parent = null;
//        return leaf;
//    }
//    public static Tree find(Tree cur,int val) {
//
//        Tree result = null;
//        if(cur.l != null)
//            result = find(cur.l,val);
//
//
//        if(cur.x == val)
//            return cur;
//        if(result ==null && cur.r != null)
//            result = find(cur.r,val);
//
//        return result;
//
//    }
//    public static void main(String[] args) {
//        Tree treeTree = new Tree(4,
//                new Tree(2),
//                new Tree(8,
//                        null,
//                        new Tree(7, new Tree(6), new Tree(1, new Tree(3), new Tree(5)))
//                )
//        );
//        
//        System.out.println(solution(treeTree, 6));
//    }
//}
