package com.company.leetcode;

import java.util.Stack;

public class RemoveKDigits {
    public static String removeKdigits(String num, int k) {
        Stack<Character> stack = new Stack<>();

        for (char digit : num.toCharArray()) {
            while (!stack.isEmpty() && k > 0 && stack.peek() > digit) {
                stack.pop();
                k -= 1;
            }
            stack.add(digit);
        }

        for (int i = 0; i < k; ++i) {
            stack.pop();
        }

        StringBuilder sb = new StringBuilder();
        boolean leadingZero = true;
        for (char digit : stack) {
            if (leadingZero && digit == '0'){
                continue;
            }
            leadingZero = false;
            sb.append(digit);
        }

        if (sb.isEmpty()){
            return "0";
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(removeKdigits("1432219", 3));
    }
}
