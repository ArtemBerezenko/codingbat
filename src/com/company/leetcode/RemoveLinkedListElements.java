package com.company.leetcode;

public class RemoveLinkedListElements {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }


    public static ListNode removeElements(ListNode head, int val) {

        ListNode result = new ListNode(0);
        ListNode current = result;

        while (head != null) {
            if (head.val != val) {
                current.next = new ListNode(head.val);
                current = current.next;
            }
            head = head.next;
        }

        return result.next;
    }

    public static ListNode removeElements2(ListNode head, int val) {

        ListNode result = new ListNode(0);
        result.next = head;
        ListNode current = result;

        while (current.next != null) {
            if (current.next.val == val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }

        return result.next;
    }

    public static void main(String[] args) {
        ListNode list = new ListNode(2, new ListNode(2, new ListNode(2, new ListNode(2, new ListNode(2)))));
        removeElements(list, 2);
    }
}
