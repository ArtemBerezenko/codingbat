package com.company.Hackerrank.trees;

import java.util.Scanner;

public class HeightOfABinaryTree {

    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }
    }

    public static int height(Node root) {
        if (root == null) {
            return -1;
        } else {
            return 1 + Math.max(height(root.left), height(root.right));
        }
    }

//    public static int height(Node root) {
//        int leftHeight = 0;
//        int rightHeight = 0;
//        if (root.left != null) {
//            leftHeight = 1 + height(root.left);
//        }
//        if (root.right != null) {
//            rightHeight = 1 + height(root.right);
//        }
//        return Math.max(leftHeight, rightHeight);
//    }

// Wrong attempt:
//    public static int height(Node root) {
//        if (root.left != null) {
//            currentHeight++;
//            height(root.left);
//        } else if (root.right != null) {
//            height(root.right);
//        } else {
//            if (currentHeight > height) {
//                height = currentHeight;
//            }
//            currentHeight--;
//        }
//        return height;
//    }

//    public static int height(Node root) {
//        leftHeight = getLeftHeight(root);
//        rightHeight = getRightHeight(root);
//        return Math.max(leftHeight, rightHeight);
//    }




    public static Node insert(Node root, int data) {
        if (root == null) {
            return new Node(data);
        } else {
            Node cur;
            if (data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node root = null;
        while (t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
        int height = height(root);
        System.out.println(height);
    }
}
