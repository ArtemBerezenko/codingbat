package com.company.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.stream.Collectors;

public class NumberOfStudentsUnableToEatLunch {
    public static int countStudents(int[] students, int[] sandwiches) {
        Queue<Integer> queue = Arrays.stream(students).boxed().collect(Collectors.toCollection(LinkedList::new));
        Stack<Integer> stack = new Stack<>();
        stack.addAll(Arrays.stream(sandwiches).boxed().toList().reversed());

        int i = 0;
        while (!queue.isEmpty() && i < queue.size()) {
            if (queue.peek().equals(stack.peek())) {
                stack.pop();
                queue.poll();
                i = 0;
            } else {
                queue.add(queue.poll());
                i++;
            }
        }

        return queue.size();
    }

    public static void main(String[] args) {
        System.out.println(countStudents(new int[]{1, 1, 0, 0}, new int[]{0, 1, 0, 1}));
//        System.out.println(countStudents(new int[]{1,1,1,0,0,1}, new int[]{1,0,0,0,1,1}));

    }
}
