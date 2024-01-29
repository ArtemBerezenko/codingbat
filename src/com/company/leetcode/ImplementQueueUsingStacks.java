package com.company.leetcode;

import java.util.Stack;

public class ImplementQueueUsingStacks {

    public static class MyQueue {
        private Stack<Integer> head;
        private Stack<Integer> tail;
        private int front;

        public MyQueue() {
            this.head = new Stack<>();
            this.tail = new Stack<>();
        }

        public void push(int x) {
            if (head.isEmpty()) {
                front = x;
            }
            head.push(x);
        }

        public int pop() {
            if (tail.isEmpty()) {
                while (!head.isEmpty()) {
                    tail.push(head.pop());
                }
            }
            return tail.pop();
        }

        public int peek() {
            if (tail.isEmpty()) {
                return front;
            }
            return head.peek();
        }

        public boolean empty() {
            return head.isEmpty() && tail.isEmpty();
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
