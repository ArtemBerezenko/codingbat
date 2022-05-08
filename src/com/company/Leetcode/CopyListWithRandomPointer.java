package com.company.Leetcode;

public class CopyListWithRandomPointer {

    public static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public static Node copyRandomList(Node head) {
        Node intermediate = head;
        while (intermediate != null) {
            Node temp = intermediate.next;
            intermediate.next = new Node(intermediate.val);
            intermediate.next.next = temp;
            intermediate = intermediate.next.next;
        }
        Node interweaved = head;
        while (interweaved != null) {
            if (interweaved.random != null) {
                interweaved.next.random = interweaved.random.next;
            }
            interweaved = interweaved.next.next;
        }

        Node result = new Node(0);
        result.next = head;
        Node current = result;

        Node headResult = new Node(0);
        headResult.next = head;
        Node headCurrent = headResult;
        while (current.next != null) {
            current.next = current.next.next;
            current = current.next;
            headCurrent.next.next = headCurrent.next.next.next;
            headCurrent = headCurrent.next;
        }

        return result.next;
    }

    public static void main(String[] args) {
        Node node0 = new Node(7);
        Node node1 = new Node(13);
        Node node2 = new Node(11);
        Node node3 = new Node(10);
        Node node4 = new Node(1);

        node0.next = node1;
        node1.next = node2;
        node1.random = node0;

        node2.next = node3;
        node2.random = node4;

        node3.next = node4;
        node3.random = node2;

        node4.random = node0;

        display(copyRandomList(node0));
    }


    private static void display(Node head) {
        while (head != null) {
            System.out.println(head.val);
            System.out.println(head.random != null ? head.random.val : null);
            head = head.next;
        }
    }
}


//        7
//        null
//        13
//        7
//        11
//        1
//        10
//        11
//        1
//        7