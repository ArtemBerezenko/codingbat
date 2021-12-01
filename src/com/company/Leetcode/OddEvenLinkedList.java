package com.company.Leetcode;

public class OddEvenLinkedList {

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

    public static ListNode oddEvenList(ListNode head) {
        ListNode oddResult = new ListNode();
        ListNode evenResult = new ListNode();
        ListNode currentOdd = oddResult;
        ListNode currentEven = evenResult;

        boolean isEven = false;
        while (head != null) {
            if (isEven) {
                currentEven.next = new ListNode(head.val);
                currentEven = currentEven.next;
                isEven = false;
            } else {
                currentOdd.next = new ListNode(head.val);
                currentOdd = currentOdd.next;
                isEven = true;
            }
            head = head.next;
        }

        evenResult = evenResult.next;
        oddResult = oddResult.next;

        ListNode result = new ListNode();
        ListNode current = result;
        while (oddResult != null && oddResult.next != null) {
            current.next = new ListNode(oddResult.val);
            current = current.next;
            oddResult = oddResult.next;
        }

        if (oddResult != null) {
            current.next = new ListNode(oddResult.val, evenResult);
        }
        return result.next;
    }

    public ListNode oddEvenListSolution(ListNode head) {
        if (head == null) return null;
        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even;
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }

    public static void main(String[] args) {
        ListNode list = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        oddEvenList(list);
    }
}
