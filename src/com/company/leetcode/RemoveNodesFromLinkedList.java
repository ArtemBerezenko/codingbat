package com.company.leetcode;


import java.util.LinkedList;

public class RemoveNodesFromLinkedList {

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

    public static ListNode removeNodes(ListNode head) {
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(head.val);
        head = head.next;

        while (!queue.isEmpty() && head != null) {

            if (queue.getLast() > head.val) {
                queue.add(head.val);
                head = head.next;
                continue;
            }

            while (!queue.isEmpty() && queue.getLast() < head.val) {
                queue.removeLast();
            }
            queue.add(head.val);
            head = head.next;
        }

        ListNode resultNode = new ListNode();
        ListNode dummy = resultNode;

        while (!queue.isEmpty()) {
            dummy.next = new ListNode(queue.poll());
            dummy = dummy.next;
        }

        return resultNode.next;
    }

    public static void main(String[] args) {
        System.out.println(removeNodes(new ListNode(5, new ListNode(2, new ListNode(13, new ListNode(3, new ListNode(8)))))));

    }
}
