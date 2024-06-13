package com.company.leetcode;

import java.util.Arrays;

public class MinimumNumberOfMovesToSeatEveryone {

    public static int minMovesToSeat(int[] seats, int[] students) {
        Arrays.sort(seats);
        Arrays.sort(students);

        int count = 0;
        for (int i = 0; i < seats.length; i++) {
            if (seats[i] != students[i]) {
                count += Math.abs(seats[i] - students[i]);
            }
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(minMovesToSeat(new int[] {3,1,5}, new int[] {2,7,4}));
    }
}
