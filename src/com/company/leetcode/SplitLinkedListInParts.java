package com.company.leetcode;

public class SplitLinkedListInParts {

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

    public static ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] result = new ListNode[k];

        // get total size of linked list
        int size = 0;
        ListNode current = head;
        while (current != null) {
            size++;
            current = current.next;
        }

        // minimum size for the k parts
        int splitSize = size / k;

        // Remaining nodes after splitting the k parts evenly.
        // These will be distributed to the first (size % k) nodes
        int remainingParts = size % k;

        current = head;
        ListNode prev = current;

        for (int i = 0; i < k; i++) {
            // create the i-th part
            ListNode newPart = current;
            // calculate size of i-th part
            int currentSize = splitSize;
            if (remainingParts > 0) {
                remainingParts--;
                currentSize++;
            }

            // traverse to end of new part
            int j = 0;
            while (j < currentSize) {
                prev = current;
                current = current.next;
                j++;
            }
            // cut off the rest of linked list
            if (prev != null) {
                prev.next = null;
            }

            result[i] = newPart;
        }

        return result;
    }

    public static void main(String[] args) {
        //1,2,3,4,5,6,7,8,9,10
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6, new ListNode(7, new ListNode(8, new ListNode(9, new ListNode(10))))))))));
        System.out.println(splitListToParts(head, 3));
    }
}
