package com.company.Hackerrank;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class InsertNode {

    static class SinglyLinkedListNode {
        public int data;
        public SinglyLinkedListNode next;

        public SinglyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
        }
    }

    static class SinglyLinkedList {
        public SinglyLinkedListNode head;
        public SinglyLinkedListNode tail;

        public SinglyLinkedList() {
            this.head = null;
            this.tail = null;
        }

        public void insertNode(int nodeData) {
            SinglyLinkedListNode node = new SinglyLinkedListNode(nodeData);

            if (this.head == null) {
                this.head = node;
            } else {
                this.tail.next = node;
            }

            this.tail = node;
        }
    }

    public static void printSinglyLinkedList(SinglyLinkedListNode node, String sep, BufferedWriter bufferedWriter) throws IOException {
        while (node != null) {
            bufferedWriter.write(String.valueOf(node.data));

            node = node.next;

            if (node != null) {
                bufferedWriter.write(sep);
            }
        }
    }

    static SinglyLinkedListNode insertNodeAtPosition1(SinglyLinkedListNode head, int data, int position) {
        int count = 0;
        SinglyLinkedList list = new SinglyLinkedList();
        while (head != null && count < position) {
            list.insertNode(head.data);
            head = head.next;
            count++;
        }

        list.insertNode(data);

        while (head != null) {
            list.insertNode(head.data);
            head = head.next;
        }

        return list.head;
    }

    static SinglyLinkedListNode insertNodeAtPosition2(SinglyLinkedListNode head, int data, int position) {
        int count = 0;
        SinglyLinkedListNode node = null;
        SinglyLinkedListNode tail = null;
        while (head != null) {
            if (count == position) {
                SinglyLinkedListNode current = new SinglyLinkedListNode(data);
                if (node == null) {
                    node = current;
                } else {
                    tail.next = current;
                }
                tail = current;
            }
            SinglyLinkedListNode current = new SinglyLinkedListNode(head.data);
            if (node == null) {
                node = current;
            } else {
                tail.next = current;
            }
            tail = current;
            head = head.next;
            count++;
        }
        return node;
    }

    static SinglyLinkedListNode insertNodeAtPosition(SinglyLinkedListNode head, int data, int position) {
        SinglyLinkedListNode node = new SinglyLinkedListNode(head.data);
        if (position == 0) {
            node.data = data;
            node.next = head;
            return node;
        } else {
            node.next = insertNodeAtPosition(head.next, data, position - 1);
        }
        return node;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        SinglyLinkedList llist = new SinglyLinkedList();

        int llistCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < llistCount; i++) {
            int llistItem = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            llist.insertNode(llistItem);
        }

        int data = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int position = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        SinglyLinkedListNode llist_head = insertNodeAtPosition(llist.head, data, position);

        printSinglyLinkedList(llist_head, " ", bufferedWriter);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

