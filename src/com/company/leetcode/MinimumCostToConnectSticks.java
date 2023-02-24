package com.company.leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MinimumCostToConnectSticks {

    public static int connectSticksMySolution(int[] sticks) {
        Arrays.sort(sticks);
        int total = 0;
        int current = 0;

        for (int i = 0; i < sticks.length - 1; i++) {
            current = Math.max(sticks[i], current) + sticks[i + 1];
            total = total + current;
        }
        return total;
    }
    public static int connectSticksEducativeSolution(int[] sticks) {
        int total = 0;

        for (int i = 0; i < sticks.length - 1; i++) {
            Arrays.sort(sticks);
            int prev = total;
            total = sticks[i] + sticks[i + 1];
            sticks[i + 1] = total;
            total = total + prev;
        }
        return total;
    }

    public static int connectSticks(int[] sticks) {
        int total = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for (int stick : sticks) {
            queue.add(stick);
        }

        while (queue.size() > 1) {
            int current = queue.poll() + queue.poll();
            total += current;
            queue.add(current);
        }

        return total;
    }


    public static void main(String[] args) {
        System.out.println(connectSticks(new int[] {1,8,3,5}));
    }
}
