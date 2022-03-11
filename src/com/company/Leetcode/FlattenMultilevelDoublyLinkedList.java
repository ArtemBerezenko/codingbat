package com.company.Leetcode;

public class FlattenMultilevelDoublyLinkedList {

    public static class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;

        Node() {}

        Node(int val) {
            this.val = val;
            this.prev = this;
        }

        Node(int val, Node nextNode) {
            this.val = val;
            this.prev = this;
            this.next = nextNode;
            this.next.prev = this;
        }

        Node(int val, Node nextNode, Node child) {
            this.val = val;
            this.prev = this;
            this.next = nextNode;
            this.next.prev = this;
            this.child = child;
        }

    }

    public static Node flatten(Node head) {
        Node current = head;
        while (head != null) {
            if (head.child != null) {
                if (head.next == null) {
                    head.next = head.child;
                    head.child.prev = head;
                } else {
                    Node tmp = head.next;
                    head.next = head.child;
                    head.child.prev = head;
                    while (head.child.next != null)  {
                        head.child = head.child.next;
                    }
                    head.child.next = tmp;
                    tmp.prev = head.child;
                }
                head.child = null;

            }
            head = head.next;
        }
        return current;
    }

    public static void main(String[] args) {
        Node child1 = new Node(11, new Node(12));

        Node child2 = new Node(7, new Node(8, new Node(9, new Node(10)), child1));

        Node parent = new Node(1, new Node(2, new Node(3, new Node(4, new Node(5, new Node(6))), child2)));

        Node result = flatten(parent);
        System.out.println(result);
    }
}


//1,2,3,4,5,6,null,null,null,7,8,9,10,null,null,11,12