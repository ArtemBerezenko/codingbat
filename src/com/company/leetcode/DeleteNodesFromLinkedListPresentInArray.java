package com.company.leetcode;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class DeleteNodesFromLinkedListPresentInArray {

    private static class ListNode {
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

    public static ListNode modifiedList(int[] nums, ListNode head) {
        Set<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toSet());

        while (head != null && set.contains(head.val)) {
            head = head.next;
        }

        ListNode dummy = head;

        while (dummy != null && dummy.next != null) {
            if (set.contains(dummy.next.val)) {
                dummy.next = dummy.next.next;
            } else {
                dummy = dummy.next;
            }
        }

        return head;
    }

    public static void main(String[] args) {
        System.out.println(modifiedList(new int[] {1,2,3}, new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))))));
    }
}
