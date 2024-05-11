package com.company.leetcode;

import java.util.Arrays;

public class BoatsToSavePeople {
    public static int numRescueBoats(int[] people, int limit) {
        int l = 0;
        int r = people.length - 1;
        int count = 0;
        Arrays.sort(people);

        while (l <= r) {
            count++;
            if (people[l] + people[r] <= limit) {
                l++;
            }
            r--;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(numRescueBoats(new int[]{3, 2, 2, 1}, 3));
    }
}
