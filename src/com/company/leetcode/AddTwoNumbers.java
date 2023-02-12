package com.company.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class AddTwoNumbers {


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

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int sum = 0;
        int remainder = 0;
        ListNode result = new ListNode(0);
        ListNode current = result;
        int count = 0;
        while (l1 != null || l2 != null) {
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            sum = sum + remainder;

            if (count == 0) {
                result.val = sum % 10;
            } else {
                current.next = new ListNode(sum % 10);
                current = current.next;
            }
            remainder = sum / 10;
            sum = 0;
            count++;
        }
        if (remainder > 0) {
            current.next = new ListNode(remainder);
        }
        return result;
    }

    public static ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        List<Integer> first = new ArrayList<>();
        List<Integer> second = new ArrayList<>();
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        Stack<Integer> third = new Stack<>();
        int remainder = 0;
        ListNode result;

        while (l1 != null) {
            first.add(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            second.add(l2.val);
            l2 = l2.next;
        }
        for (int i = first.size() - 1; i >= 0; i--) {
            stack1.add(first.get(i));
        }
        for (int i = second.size() - 1; i >= 0; i--) {
            stack2.add(second.get(i));
        }

        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            int sum = 0;
            if (!stack1.isEmpty()) {
                sum += stack1.pop();
            }
            if (!stack2.isEmpty()) {
                sum += stack2.pop();
            }
            sum = sum + remainder;
            third.add(sum % 10);
            remainder = sum / 10;
        }

        if (remainder > 0) {
            third.add(remainder);
        }

        result = new ListNode(third.pop());

        while (!third.isEmpty()) {
            ListNode current = new ListNode(third.pop());
            current.next = result;
            result = current;
        }

        return result;
    }

    public static ListNode addTwoNumbersRecursion(ListNode l1, ListNode l2) {
        ListNode result = new ListNode();
        result = sum(l1, l2, result.next, 0);
        return result;
    }

    private static ListNode sum(ListNode l1, ListNode l2, ListNode result, int acc) {
        if (l1 == null && l2 == null) {
            if (acc != 0) {
                return new ListNode(acc, result);
            }
            return result;
        }
        if (l2 == null) {
            int sum = l1.val + acc;
            acc = sum / 10;
            result = new ListNode(sum % 10, sum(l1.next, null, result, acc));
        } else if (l1 == null) {
            int sum = l2.val + acc;
            acc = sum / 10;
            result = new ListNode(sum % 10, sum(null, l2.next, result, acc));
        } else {
            int sum = l1.val + l2.val + acc;
            acc = sum / 10;
            result = new ListNode(sum % 10, sum(l1.next, l2.next, result, acc));
        }
        return result;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(9);
        node1.next = new ListNode(9);
        node1.next.next = new ListNode(9);

        ListNode node2 = new ListNode(9);
//        node2.next = new ListNode(6);
//        node2.next.next = new ListNode(4);

        ListNode result = addTwoNumbersRecursion(node1, node2);
        ListNode next = result.next;
        while (next != null) {
            next = result.next;
            System.out.println(next);
        }
    }
}
