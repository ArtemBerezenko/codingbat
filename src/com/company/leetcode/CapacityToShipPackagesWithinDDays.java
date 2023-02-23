package com.company.leetcode;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.LinkedList;

public class CapacityToShipPackagesWithinDDays {
    public static int shipWithinDays(int[] weights, int days) {
        int minWeight = Arrays.stream(weights).boxed().sorted().collect(Collectors.toCollection(LinkedList::new)).getLast();
        int maxWeight = Arrays.stream(weights).boxed().mapToInt(Integer::intValue).sum();

        int l = minWeight;
        int r = maxWeight;

        while (l < r) {
            int mid = l + (r - l) / 2;
            if (isPossible(weights, mid, days)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    private static boolean isPossible(int[] weights, int capacity, int days) {
        int daysNumber = 1;
        int currentWeight = 0;

        for (int i = 0; i < weights.length; i++) {
            currentWeight += weights[i];
            if (currentWeight > capacity) {
                daysNumber++;
                currentWeight = weights[i];
            }
        }
        return daysNumber <= days;
    }

    public static void main(String[] args) {
        System.out.println(shipWithinDays(new int[] {1,2,3,4,5,6,7,8,9,10}, 5));
    }

}
