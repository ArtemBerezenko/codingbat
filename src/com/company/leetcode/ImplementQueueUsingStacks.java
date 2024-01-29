package com.company.leetcode;

import java.util.Stack;

public class ImplementQueueUsingStacks {

    public static class MyQueue {
        private Stack<Integer> head;
        private Stack<Integer> tail;

        public MyQueue() {
            this.head = new Stack<>();
            this.tail = new Stack<>();
        }

        public void push(int x) {
            tail = new Stack<>();
            tail.addAll(head);
            head = new Stack<>();
            head.push(x);
            head.addAll(tail);
        }

        public int pop() {
            return head.pop();
        }

        public int peek() {
            return head.peek();
        }

        public boolean empty() {
            return head.isEmpty();
        }
    }


    public static void main(String[] args) {
        MyQueue queue = new MyQueue();
        queue.push(1);
        queue.push(2);
        System.out.println(queue.peek());
        System.out.println(queue.pop());
        System.out.println(queue.empty());
        

    }
}
