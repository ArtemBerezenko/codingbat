package com.company.leetcode;


import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class TimeNeededToBuyTickets {
    public static int timeRequiredToBuy(int[] tickets, int k) {
        Queue<Integer> queue = new ArrayDeque<>(Arrays.stream(tickets).boxed().toList());
        int i = 0;
        int count = 0;
        int length = tickets.length - 1;
        
        while (!queue.isEmpty()) {
            int item = queue.poll();
            
            if (item - 1 == 0 && i == k) {
                return count + 1;
            }
            
            if (item != 0) {
                queue.add(item - 1);
                count++;
            } else {
                queue.add(item);
            }
            
            i = i == length ? 0 : i + 1;
        }
        
        return count;
    }

    public static void main(String[] args) {
        System.out.println(timeRequiredToBuy(new int[] {2,3,2}, 2));
    }
}
