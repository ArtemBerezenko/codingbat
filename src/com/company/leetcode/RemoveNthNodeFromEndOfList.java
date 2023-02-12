package com.company.leetcode;

import java.util.HashMap;
import java.util.Map;

public class RemoveNthNodeFromEndOfList {

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


    public static ListNode removeNthFromEndMY(ListNode head, int n) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;

        while (head != null) {
            map.put(count, head.val);
            count++;
            head = head.next;
        }
        count--;

        map.remove(count - n + 1);

        ListNode result = null;

        for (int i = count; i >= 0; i--) {
            if (map.containsKey(i)) {
                if (i == count) {
                    result = new ListNode(map.get(i));
                } else {
                    result = new ListNode(map.get(i), result);
                }
            }
        }
        return result;
    }

    public static ListNode removeNthFromEndTwoPassAlgorithm(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        int length  = 0;
        ListNode first = head;
        while (first != null) {
            length++;
            first = first.next;
        }
        length -= n;
        first = dummy;
        while (length > 0) {
            length--;
            first = first.next;
        }
        first.next = first.next.next;
        return dummy.next;
    }

    public static ListNode removeNthFromEndOnePassAlgorithm(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;
        // Advances first pointer so that the gap between first and second is n nodes apart
        for (int i = 1; i <= n + 1; i++) {
            first = first.next;
        }
        // Move first to the end, maintaining the gap
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode list = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));

        removeNthFromEndMY(list, 2);
        removeNthFromEndTwoPassAlgorithm(list, 2);
        removeNthFromEndOnePassAlgorithm(list, 2);
    }
}
