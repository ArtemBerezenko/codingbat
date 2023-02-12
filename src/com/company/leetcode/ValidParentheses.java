package com.company.leetcode;

import java.util.Map;
import java.util.Stack;

public class ValidParentheses {
    public static boolean isValid(String s) {
        if (s.isEmpty()) return true;
        Map<String, String> map = Map.of(")","(",  "}","{",  "]", "[");
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            String sub = s.substring(i, i + 1);
            if (map.containsKey(sub)) {
                if (stack.empty()) return false;
                String last = stack.peek();
                if (map.get(sub).equals(last)) {
                    stack.pop();
                } else {
                    stack.push(sub);
                }
            } else {
                stack.push(sub);
            }
        }
        return stack.empty();
    }


    public static void main(String[] args) {
        System.out.println(isValid("(])"));
        System.out.println(isValid("{[]}"));
        System.out.println(isValid("([)]"));
        System.out.println(isValid("([]"));
    }
}
