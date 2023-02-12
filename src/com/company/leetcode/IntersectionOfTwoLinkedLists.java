package com.company.leetcode;

import java.util.HashSet;
import java.util.Set;

public class IntersectionOfTwoLinkedLists {

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


    static ListNode add(ListNode head, int data) {
        ListNode new_node = new ListNode();
        new_node.val = data;
        new_node.next = head;

        head = new_node;
        return head;
    }


    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a = headA;
        ListNode b = headB;
        Set<ListNode> set = new HashSet<>();

        while (a != null) {
            set.add(a);
            a = a.next;
        }

        while (b != null) {
            if (set.contains(b)) {
                return b;
            }
            b = b.next;
        }

        return null;
    }


    public static void main(String[] args) {
        testCase1();
    }

    private static void testCase1() {
        ListNode head1 = null;

        head1 = add(head1, 1);
        head1 = add(head1, 4);

        ListNode head2 = null;

        head2 = add(head2, 1);
        head2 = add(head2, 6);
        head2 = add(head2, 5);

        ListNode head3 = null;

        head3 = add(head3, 5);
        head3 = add(head3, 4);
        head3 = add(head3, 8);

        head1.next.next = head3;
        head2.next.next.next = head3;


        ListNode result = getIntersectionNode(head1, head2);
        System.out.println(result.val);
    }
}
