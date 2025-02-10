package com.company.leetcode;

import java.util.Stack;
import java.util.stream.Collectors;

public class ClearDigits {
    public static String clearDigits(String s) {
        Stack<Character> stack = new Stack<>();

        for (Character c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                stack.pop();
            } else {
                stack.add(c);
            }
        }

        return stack.stream().map(String::valueOf).collect(Collectors.joining());
    }

    public static void main(String[] args) {
        System.out.println(clearDigits("abc"));
    }
}
