package com.company.leetcode;

import java.util.Stack;

public class DecodeString {

    public static String decodeString(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c != ']') {
                stack.push(c);
            } else {
                var result = new StringBuilder();
                var sb = new StringBuilder();
                while (stack.peek() != '[') {
                    sb.append(stack.pop());
                }
                stack.pop();
                var k = new StringBuilder();

                while (!stack.isEmpty() && Character.isDigit(stack.peek())) {
                    k.append(stack.pop());
                }

                int n = Integer.parseInt(k.reverse().toString());

                sb.reverse();
                result.append(String.valueOf(sb).repeat(Math.max(0, n)));

                for (char ch : result.toString().toCharArray()) {
                    stack.push(ch);
                }
            }
        }

        char[] result = new char[stack.size()];
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }

        return new String(result);
    }

    public static void main(String[] args) {
        System.out.println(decodeString("100[leetcode]"));
    }
}
