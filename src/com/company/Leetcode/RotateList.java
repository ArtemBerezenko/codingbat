package com.company.Leetcode;

public class RotateList {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null){
            return head;
        }
        int length = count(head);
        k = k % length;

        ListNode result = head;

        for(int i = 0; i < k; i++){
            result = rotationByOne(result);
        }

        return result;
    }

    private static ListNode rotationByOne(ListNode head){
        ListNode tmp = head;
        while (tmp.next.next != null) {
            tmp = tmp.next;
        }

        ListNode end = tmp.next;
        tmp.next = null;
        end.next = head;

        return end;
    }

    private static int count(ListNode node) {
        int count = 0;

        while (node != null) {
            node = node.next;
            count++;
        }
        return count;
    }

    private static ListNode reverse(ListNode node) {
        ListNode dummy = null;
        while (node != null) {
            ListNode tmp = dummy;
            dummy = new ListNode(node.val);
            dummy.next = tmp;
            node = node.next;
        }
        return dummy;
    }

    public static void main(String[] args) {
        ListNode list = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        rotateRight(list, 2);
    }
}

//
//    ListNode reversedList = reverse(head);
//
//    ListNode result = new ListNode(0);
//    ListNode current = result;
//
//        while (head != null && length != k) {
//                current.next = new ListNode(head.val);
//                current = current.next;
//                head = head.next;
//                length--;
//                }
//
//                result = result.next;
//
//                while (reversedList != null && k > 0) {
//                ListNode tmp = result;
//                result = new ListNode(reversedList.val);
//                result.next = tmp;
//                reversedList = reversedList.next;
//                k--;
//                }
//
//                return result;