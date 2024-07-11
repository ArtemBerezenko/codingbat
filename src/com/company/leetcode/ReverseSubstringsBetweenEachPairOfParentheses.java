package com.company.leetcode;

import java.util.Stack;

public class ReverseSubstringsBetweenEachPairOfParentheses {
    public static String reverseParentheses(String s) {
        Stack<String> stack = new Stack<>();

        for (Character c : s.toCharArray()) {
            if (c == ')') {
                StringBuilder sb = new StringBuilder();

                while (!stack.empty() && !stack.peek().equals("(")) {
                    sb.append(new StringBuilder(stack.pop()).reverse());
                }
                stack.pop(); // Remove the '('
                stack.push(sb.toString());
            } else {
                stack.push(String.valueOf(c));
            }
        }

        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.insert(0, stack.pop());
        }

        return result.toString();
    }


    public static String reverseParenthesesSOLUTION(String s) {
        Stack<Integer> stack = new Stack<>();
        StringBuilder res = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(res.length());
            } else if (c == ')') {
                int startInd = stack.pop();
                String reversed = new StringBuilder(res.substring(startInd)).reverse().toString();
                res.replace(startInd, res.length(), reversed);
            } else {
                res.append(c);
            }
        }

        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(reverseParentheses("(ed(et(oc))el)"));
    }
}
