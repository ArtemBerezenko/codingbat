package com.company.leetcode;

import java.util.Stack;

public class PalindromeLinkedListII {

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
        ListNode node = head;
        Stack<Integer> stack = new Stack<>();
        
        while (node != null) {
            stack.add(node.val);
            node = node.next;
        }
        
        while (head != null) {
            if (stack.pop() != head.val) {
                return false;
            }
            head = head.next;
        }
        
        return true;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(1))));
        System.out.println(isPalindrome(node));
    }
}
