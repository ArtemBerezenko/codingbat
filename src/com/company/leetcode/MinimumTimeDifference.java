package com.company.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimumTimeDifference {
    public static int findMinDifference(List<String> timePoints) {

        int[] minutes = new int[timePoints.size()];
        for (int i = 0; i < timePoints.size(); i++) {
            String time = timePoints.get(i);
            int h = Integer.parseInt(time.substring(0, 2));
            int m = Integer.parseInt(time.substring(3));
            minutes[i] = h * 60 + m;
        }

        Arrays.sort(minutes);

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < minutes.length - 1; i++) {
            ans = Math.min(ans, minutes[i + 1] - minutes[i]);
        }

        return Math.min(ans, 24 * 60 - minutes[minutes.length - 1] + minutes[0]);
    }

    private static int getValue(String time) {
        int h = Integer.parseInt(time.substring(0, 2));
        int m = Integer.parseInt(time.substring(3));
        return h * 60 + m;
    }

    public static void main(String[] args) {
        System.out.println(findMinDifference(new ArrayList<>(List.of("23:59","00:00"))));
    }
}
