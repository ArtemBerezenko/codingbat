package com.company.leetcode;

public class ReorderList {

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

    public static void reorderList(ListNode head) {
        ListNode current = head;
        int n = countElements(head);
        int i = 0;
        while (i < n / 2) {
            ListNode next = reorderList(head, i, n + i);
            ListNode temp = current.next;
            current.next = next;
            current.next.next = temp;
            current = current.next.next;
            i++;
        }
        current.next = null;
    }

    private static ListNode reorderList(ListNode node, int i, int n) {
        if (i == n - 1) {
            return node;
        }
        return reorderList(node.next, i + 1, n);
    }

    private static int countElements(ListNode head) {
        ListNode temp = head;
        int count = 0;
        while (temp != null) {
            temp = temp.next;
            count++;
        }
        return count;
    }

    public static void reorderList1(ListNode head) {
        reorderList(head, head);
    }

    private static ListNode reorderList(ListNode head, ListNode curr) {
        if (curr == null) {
            return head;
        }

        ListNode node = reorderList(head, curr.next);
        ListNode result = null;
        if (node == curr) {
            node.next = null;
        } else if (node != null) {
            ListNode temp = node.next;
            node.next = curr;
            curr.next = null;
            if (curr != temp) {
                curr.next = temp;
                result = temp;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        //1,5,2,4,3
        reorderList1(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))))));
    }

}
