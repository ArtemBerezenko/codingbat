package com.company.leetcode;

public class MergeTwoSortedLists {

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

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l2 == null && l1 != null) return l1;
        if (l1 == null && l2 != null) return l2;

        ListNode result = new ListNode();
        ListNode current = result;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }
        if (l1 != null) {
            current.next = l1;
        }
        if (l2 != null) {
            current.next = l2;
        }
        return result.next;
    }


    public static void main(String[] args) {
//        1->2->4, 1->3->4
//        1->1->2->3->4->4
        ListNode nums1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode nums2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        mergeTwoLists(nums1, nums2);
    }
}
