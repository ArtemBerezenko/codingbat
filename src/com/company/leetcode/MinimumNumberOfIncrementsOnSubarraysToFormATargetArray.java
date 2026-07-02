package com.company.leetcode;

import java.util.Stack;

public class MinimumNumberOfIncrementsOnSubarraysToFormATargetArray {
    public static int minNumberOperations(int[] target) {
        Stack<Integer> stack = new Stack();
        int count = 0;
        stack.add(target[0]);

        for (int i = 0 ; i < target.length ; i ++) {
            if (!stack.isEmpty() && target[i] < stack.peek()) {
                count += stack.pop() - target[i];
                stack.clear();
            }
            stack.add(target[i]);
        }
        count += stack.pop();
        return count;
    }

    public static void main(String[] args) {
        System.out.println(minNumberOperations(new int[] {3,1,5,4,2}));
    }
}
