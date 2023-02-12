package com.company.leetcode;

public class MergeTwoSortedListsII {


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

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode result = new ListNode();
        result = merge(list1, list2, result.next);
        return result;
    }

    private static ListNode merge(ListNode list1, ListNode list2, ListNode result) {
        if (list1 == null && list2 == null) {
            return result;
        }

        if (list1 == null) {
            result = new ListNode(list2.val, merge(list1, list2.next, result));
        } else if (list2 == null) {
            result = new ListNode(list1.val, merge(list1.next, list2, result));
        } else if (list1.val <= list2.val) {
            result = new ListNode(list1.val, merge(list1.next, list2, result));
        } else {
            result = new ListNode(list2.val, merge(list1, list2.next, result));
        }
        return result;
    }


    public static void main(String[] args) {
//        1->2->4, 1->3->4
//        1->1->2->3->4->4
        ListNode nums1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode nums2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        mergeTwoLists(nums1, nums2);
    }
}
