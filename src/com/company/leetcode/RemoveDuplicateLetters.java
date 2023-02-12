package com.company.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.stream.Collectors;

public class RemoveDuplicateLetters {

    public static String removeDuplicateLetters(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        Stack<Character> stack = new Stack<>();
        for (char entry : s.toCharArray()) {
            if (stack.contains(entry)) {
                map.put(entry, map.get(entry) - 1);
                continue;
            }
            while (!stack.isEmpty() && stack.peek() > entry && map.get(stack.peek()) > 0) {
                stack.pop();
            }
            if (!stack.contains(entry)) {
                stack.push(entry);
            }
            map.put(entry, map.get(entry) - 1);

        }
        return stack.stream().map(String::valueOf).collect(Collectors.joining());
    }

    public static void main(String[] args) {
        System.out.println(removeDuplicateLetters("cdadabcc"));
    }
}
