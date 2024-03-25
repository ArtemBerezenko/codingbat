package com.company.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class DailyTemperatures {
    public static int[] dailyTemperatures(int[] temperatures) {
        int[] answer = new int[temperatures.length];
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < temperatures.length; i++) {
            int currentTemp = temperatures[i];
            while (!stack.isEmpty() && temperatures[stack.peek()] < currentTemp) {
                int prevDay = stack.pop();
                answer[prevDay] = i - prevDay;
            }
            stack.push(i);
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(dailyTemperatures(new int[] {73,74,75,71,69,72,76,73}));
    }
}
