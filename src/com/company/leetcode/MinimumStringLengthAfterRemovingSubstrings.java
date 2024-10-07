package com.company.leetcode;

import java.util.Stack;

public class MinimumStringLengthAfterRemovingSubstrings {
    public static int minLength(String s) {
        Stack<Character> stack = new Stack<>();

        stack.push(s.charAt(0));
        int i = 1;
        while (i < s.length()) {
            if (s.charAt(i) == 'B' && !stack.isEmpty() && stack.peek() == 'A') {
                stack.pop();
            } else if (s.charAt(i) == 'D' && !stack.isEmpty() && stack.peek() == 'C') {
                stack.pop();
            } else {
                stack.push(s.charAt(i));
            }
            i++;
        }

        return stack.size();
    }

    public static void main(String[] args) {
        System.out.println(minLength("ABFCACDB"));
    }
}
