package com.company.leetcode;

public class MinimumTimeToMakeRopeColorful {

    public static int minCost(String colors, int[] neededTime) {
        int globalTime = 0;
        int time = 0;
        for (int i = 0; i < colors.length(); i++) {
            if (i > 0 && colors.charAt(i - 1) != colors.charAt(i)) {
                time = 0;
            }
            globalTime += Math.min(time, neededTime[i]);
            time = Math.max(time, neededTime[i]);
        }
        return globalTime;
    }

    public static void main(String[] args) {
        System.out.println(minCost("abaac", new int[] {1,2,3,4,5}));
    }
}
