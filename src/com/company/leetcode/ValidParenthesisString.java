package com.company.leetcode;


import java.util.Stack;

public class ValidParenthesisString {

    public static boolean checkValidString(String s) {
        Stack<Character> stack = new Stack<>();

        for (Character c : s.toCharArray()) {
            stack.add(c);
        }

        int lefts = 0;
        int rights = 0;
        int stars = 0;
        while (!stack.isEmpty()) {
            Character c = stack.pop();

            if (c.equals(')')) {

                if (rights - lefts != 0) {
                    if (rights - lefts - stars != 0) {
                        return false;
                    }
                }
                rights = 0;
                lefts = 0;
                stars = 0;

                while (c.equals(')') || c.equals('*')) {
                    if (c == ')') {
                        rights++;
                    } else {
                        stars++;
                    }
                    c = stack.pop();
                }
            }


            if (c.equals('(') || c.equals('*')) {
                if (c == '(') {
                    lefts++;
                } else {
                    stars++;
                }
            }
        }

        if (rights - lefts != 0) {
            if (rights - lefts - stars != 0) {
                return false;
            }
        }

        return true;
    }

    public static boolean checkValidStringSOLUTION(String s) {
        int l = 0;
        int r = 0;

        for (int i = 0; i <= s.length() - 1; i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '*') {
                l++;
            } else {
                l--;
            }

            if (s.charAt(s.length() - 1 - i) == ')' || s.charAt(s.length() - 1 - i) == '*') {
                r++;
            } else {
                r--;
            }

            if (l < 0 || r < 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(checkValidStringSOLUTION("(*)(*))(((*)))"));
    }
}
