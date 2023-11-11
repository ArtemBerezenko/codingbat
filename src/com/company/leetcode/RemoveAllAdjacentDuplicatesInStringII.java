package com.company.leetcode;

import java.util.Stack;

public class RemoveAllAdjacentDuplicatesInStringII {

    static class Pair {
        Character value;
        int count;

        public Pair(Character value, int count) {
            this.value = value;
            this.count = count;
        }
    }

    public static String removeDuplicates(String s, int k) {
        Stack<Pair> stack = new Stack<>();

        for (Character c : s.toCharArray()) {
            if (stack.isEmpty() || !stack.peek().value.equals(c)) {
                stack.push(new Pair(c, 1));
            } else {
                if (++stack.peek().count == k) {
                    stack.pop();
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        while (!stack.isEmpty()) {
            Pair pair = stack.pop();
            while (pair.count-- > 0) {
                sb.append(pair.value);
            }
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(removeDuplicates("deeedbbcccbdaa", 3));
    }
}
