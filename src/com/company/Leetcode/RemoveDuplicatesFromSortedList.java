package com.company.Leetcode;

public class RemoveDuplicatesFromSortedList {

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

    public static ListNode deleteDuplicates(ListNode head) {
        ListNode result = new ListNode(Integer.MAX_VALUE);
        ListNode temp = result;
        while (head != null) {
            if (temp.val != head.val) {
                temp.next = new ListNode(head.val);
                temp = temp.next;
            }
            head = head.next;
        }
        return result.next;
    }

    public static void main(String[] args) {
        ListNode list = new ListNode(1, new ListNode(1, new ListNode(2)));
        deleteDuplicates(list);
    }

}
