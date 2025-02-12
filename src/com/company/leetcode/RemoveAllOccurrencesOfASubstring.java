package com.company.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class RemoveAllOccurrencesOfASubstring {
    public static String removeOccurrences(String s, String part) {
        if (part.length() > s.length()) {
            return s;
        }

        Stack<Character> stack = new Stack<>();

        for (Character c : s.toCharArray()) {
            int k = part.length() - 1;
            stack.add(c);
            List<Character> temp = new ArrayList<>();

            while (k >= 0 && !stack.isEmpty() && stack.peek().equals(part.charAt(k))) {
                temp.add(stack.pop());
                k--;
            }

            if (k > 0) {
                stack.addAll(temp.reversed());
            }
        }

        return stack.stream().map(String::valueOf).collect(Collectors.joining());
    }

    public static void main(String[] args) {
        System.out.println(removeOccurrences("daabcbaabcbc", "abc"));
    }
}
