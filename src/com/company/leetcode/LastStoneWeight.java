package com.company.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class LastStoneWeight {

    public static int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());

        Arrays.stream(stones).boxed().forEach(queue::add);

        while (queue.size() > 1) {
            Integer x = queue.poll();
            Integer y = queue.poll();
            if (x != null && y != null && y < x) {
                queue.add(x - y);
            }
        }

        return queue.size() == 1 ? queue.peek(): 0;
    }

    public static void main(String[] args) {
        System.out.println(lastStoneWeight(new int[] {1}));
    }
}
