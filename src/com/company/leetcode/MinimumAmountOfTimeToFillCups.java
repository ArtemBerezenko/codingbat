package com.company.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MinimumAmountOfTimeToFillCups {

    public static int fillCups(int[] amount) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        queue.addAll(Arrays.stream(amount).boxed().filter(i -> i > 0).sorted(Comparator.reverseOrder()).toList());

        int count = 0;

        while (queue.peek() != null && queue.peek() > 0) {
            Integer first = queue.poll();
            Integer second = queue.poll();

            queue.add(--first);
            if (second != null) {
                queue.add(--second);
            }

            count++;
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(fillCups(new int[]{0,0,0}));
    }
}
