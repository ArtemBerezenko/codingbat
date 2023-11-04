package com.company.leetcode;

import java.util.Stack;
import java.util.stream.Collectors;

public class RemoveAllAdjacentDuplicatesInString {

    public static String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();
        
        for (Character c : s.toCharArray()) {
            if (stack.isEmpty()) {
                stack.add(c);
            } else {
                Character prev = stack.peek();
                if (!c.equals(prev)) {
                    stack.add(c);
                } else {
                    stack.pop();
                }
            }
        }
        
        return stack.stream().map(Object::toString).collect(Collectors.joining());
    }

    public static void main(String[] args) {
        System.out.println(removeDuplicates("abbaca"));
    }
}
