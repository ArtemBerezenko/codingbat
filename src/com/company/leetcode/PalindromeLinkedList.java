package com.company.leetcode;

public class PalindromeLinkedList {

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


    public static boolean isPalindrome(ListNode head) {
        ListNode dummy = head;
        ListNode reverseList = null;
        while (dummy != null) {
            reverseList = new ListNode(dummy.val, reverseList);
            dummy = dummy.next;
        }

        while (head != null) {
            if (head.val != reverseList.val) {
                return false;
            }
            reverseList = reverseList.next;
            head = head.next;
        }
        return true;
    }

    public static void main(String[] args) {
        ListNode list = new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(1))));
        isPalindrome(list);
    }
}
