package com.company.Hackerrank;

import java.util.EmptyStackException;
import java.util.Scanner;

public class BalancedBrackets {

    private static class Stack<String> {

        private class Element<E> {
            private E data;
            private Element<E> next;

            public Element(E data) {
                this.data = data;
                this.next = null;
            }
        }

        private Element<String> top;

        public Stack() {
            this.top = null;
        }

        public boolean isEmpty() {
            return top == null;
        }

        public void push(String value) {
            Element<String> newTop = new Element<>(value);

            if (!isEmpty()) {
                newTop.next = top;
            }

            this.top = newTop;
        }

        public String pop() {
            if (isEmpty()) {
                throw new EmptyStackException();
            }

            Element<String> oldTop = top;
            this.top = top.next;

            return oldTop.data;
        }

        public String peek() {
            if (isEmpty()) {
                throw new EmptyStackException();
            }

            return top.data;
        }
    }

    public static boolean isPair(String str, String str2) {
        if (str.equals("{") && str2.equals("}")) return true;
        if (str.equals("[") && str2.equals("]")) return true;
        if (str.equals("(") && str2.equals(")")) return true;
        return false;
    }


    public static boolean isBalanced(String expression) {
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < expression.length(); i++) {
            if (!stack.isEmpty()) {
                if (isPair(stack.peek(), expression.substring(i, i + 1))) {
                    stack.pop();
                } else {
                    stack.push(expression.substring(i, i + 1));
                }
            } else {
                stack.push(expression.substring(i, i + 1));
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int a0 = 0; a0 < t; a0++) {
            String expression = in.next();
            System.out.println((isBalanced(expression)) ? "YES" : "NO");
        }
    }
}