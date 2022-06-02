package com.company.Leetcode;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class FairCandySwap {

    public static int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
        int aliceSum = Arrays.stream(aliceSizes).sum();
        int bobSum = Arrays.stream(bobSizes).sum();

        int delta = (bobSum - aliceSum) / 2;

        Set<Integer> bobCandySet = Arrays.stream(bobSizes).boxed().collect(Collectors.toSet());

        for (int aliceCandy : aliceSizes) {
            if (bobCandySet.contains(aliceCandy + delta)) {
                return new int[] {aliceCandy, aliceCandy + delta};
            }
        }

        return new int[] {-1, -1};
    }


    public static void main(String[] args) {
        System.out.println(fairCandySwap(new int[]{1,2,5}, new int[]{2,4}));
    }
}
