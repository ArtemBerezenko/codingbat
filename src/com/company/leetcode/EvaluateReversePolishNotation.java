package com.company.leetcode;

import java.util.Set;
import java.util.Stack;

public class EvaluateReversePolishNotation {

    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        Set<String> operations = Set.of("+", "-", "*", "/");

        for (String token : tokens) {
            if (operations.contains(token)) {
                Integer first = stack.pop();
                Integer second = stack.pop();
                switch (token) {
                    case "+" -> stack.push(second + first);
                    case "-" -> stack.push(second - first);
                    case "*" -> stack.push(second * first);
                    case "/" -> stack.push(second / first);
                }

            } else {
                stack.push(Integer.parseInt(token));
            }
        }

        return stack.pop();
    }

    public static void main(String[] args) {
        System.out.println(evalRPN(new String[]{"10","6","9","3","+","-11","*","/","*","17","+","5","+"}));
    }

}
