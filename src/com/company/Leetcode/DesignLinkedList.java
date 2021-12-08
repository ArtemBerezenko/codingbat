package com.company.Leetcode;

public class DesignLinkedList {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode prev;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

    }

    static class MyLinkedList {
        int size;
        ListNode head;
        ListNode tail;

        public MyLinkedList() {
            head = new ListNode();
            tail = new ListNode();
            head.next = tail;
            tail.prev = head;
        }

        public int get(int index) {
            if (index >= size) return -1;
            int i = 0;
            ListNode current = head;
            while (i != index && current != null) {
                current = current.next;
                i++;
            }
            return current.next.val;
        }

        public void addAtHead(int val) {
            ListNode next = head.next;
            ListNode newNode = new ListNode(val);
            head.next = newNode;
            newNode.next = next;

            if (size == 0) {
                tail.prev = newNode;
            }

            size++;
        }

        public void addAtTail(int val) {
            ListNode prev = tail.prev;
            ListNode newNode = new ListNode(val);
            prev.next = newNode;
            newNode.next = tail;
            tail.prev = newNode;
            size++;
        }

        public void addAtIndex(int index, int val) {
            if (index <= size) {
                ListNode current = head;
                int i = 0;
                while (i < index && current != null) {
                    current = current.next;
                    i++;
                }
                ListNode next = current.next;
                ListNode newNode = new ListNode(val);
                current.next = newNode;
                newNode.next = next;

                if (index == size) {
                    tail.prev = newNode;
                }
                size++;
            }
        }

        public void deleteAtIndex(int index) {
            if (index < size) {
                int i = 0;
                ListNode current = head;
                while (i < index && current != null) {
                    current = current.next;
                    i++;
                }

                ListNode next = current.next.next;
                current.next = next;
                if (index == size - 1) {
                    tail.prev = current;
                }
                size--;
            }
        }
    }

    public static void main(String[] args) {
        MyLinkedList obj = new MyLinkedList();

        obj.addAtHead(7);
        obj.addAtHead(2);
        obj.addAtHead(1);
        obj.addAtIndex(3, 0);
        obj.deleteAtIndex(2);
        obj.addAtHead(6);
        obj.addAtTail(4);
        obj.get(4);
        obj.addAtHead(4);
        obj.addAtIndex(5, 0);
        obj.addAtHead(6);
    }
}

