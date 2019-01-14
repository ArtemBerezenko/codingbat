package com.company.Hackerrank;

import java.util.*;

public class ATaleOfTwoStacks {
    public static class MyQueue<T> {
        Stack<T> stackNewestOnTop = new Stack<T>();
        Stack<T> stackOldestOnTop = new Stack<T>();

        public void enqueue(T value) { // Push onto newest stack
            stackNewestOnTop.add(value);
            if (stackOldestOnTop.isEmpty()) {
                stackOldestOnTop.add(stackNewestOnTop.firstElement());
                stackNewestOnTop.removeElement(stackNewestOnTop.firstElement());
            }
        }

        public T peek() {
            T value = null;
            if (!stackOldestOnTop.isEmpty()) {
                value = stackOldestOnTop.firstElement();
            }
            return value;
        }

        public T dequeue() {
            if (!stackOldestOnTop.isEmpty()) {
                T value = stackOldestOnTop.lastElement();
                stackOldestOnTop.removeElement(stackOldestOnTop.lastElement());
                if (!stackNewestOnTop.isEmpty()) {
                    stackOldestOnTop.add(stackNewestOnTop.firstElement());
                    stackNewestOnTop.removeElement(stackNewestOnTop.firstElement());
                }
                return value;
            }
            return null;
        }

    }


    public static void main(String[] args) {
        MyQueue<Integer> queue = new MyQueue<Integer>();

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        for (int i = 0; i < n; i++) {
            int operation = scan.nextInt();
            if (operation == 1) { // enqueue
                queue.enqueue(scan.nextInt());
            } else if (operation == 2) { // dequeue
                queue.dequeue();
            } else if (operation == 3) { // print/peek
                System.out.println(queue.peek());
            }
        }
        scan.close();
    }
}
