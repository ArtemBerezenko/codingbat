package com.company.Leetcode;

public class LinkedListCycleII {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }
    }

    static ListNode add(ListNode head_ref, int data) {
        ListNode new_node = new ListNode();
        new_node.val = data;
        new_node.next = head_ref;

        head_ref = new_node;
        return head_ref;
    }

    public static ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                ListNode node = head;
                while (node != fast) {
                    fast = fast.next;
                    node = node.next;
                }
                return node;
            }
        }

        return null;
    }

    public static void main(String[] args) {
        testCase1();
    }

    private static void testCase1() {
        ListNode head = null;

        head = add(head, -4);
        head = add(head, 0);
        head = add(head, 2);
        head = add(head, 3);

        head.next.next.next.next = head.next;


        System.out.println(detectCycle(head));
    }

    private static void testCase2() {
        ListNode head = null;

        head = add(head, 2);
        head = add(head, 1);

        head.next.next = head;


        System.out.println(detectCycle(head));
    }


}
