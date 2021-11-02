package com.company.Leetcode;

public class MiddleOfTheLinkedList {
    
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

    public static ListNode middleNode(ListNode head) {
        int length = 0;
        ListNode l = head;
        ListNode h = head;

        while (h.next != null) {
            h = h.next;
            length++;
        }

        int i = 1;
        int mid = length / 2;
        mid = length % 2 == 0 ? mid : mid + 1;
        while (i <= mid) {
            l = l.next;
            i++;
        }

        return l;
    }

    public ListNode middleNodeTwoPointersSolution(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        ListNode nums1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6))))));
        middleNode(nums1);
    }
}
