package com.company.leetcode;


import java.util.ArrayDeque;
import java.util.Queue;

public class MaximumNestingDepthOfTheParentheses {
    public static int maxDepth(String s) {
        Queue<Character> queue = new ArrayDeque<>();
        
        for (Character c : s.toCharArray()) {
            if (c == '(' || c == ')') {
                queue.add(c);
            }
        }
        
        int lefts = 0;
        int rights = 0;
        int max = 0;
        while (!queue.isEmpty()) {
            Character c = queue.poll();
            if (c != null && c == '(') {
                lefts++;
            } else {
                max = Math.max(max, lefts - rights);
                rights++;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(maxDepth("(1)+((2))+(((3)))"));
    }
    
}
