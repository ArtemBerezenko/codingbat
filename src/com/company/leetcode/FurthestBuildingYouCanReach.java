package com.company.leetcode;

import java.util.*;

public class FurthestBuildingYouCanReach {

    public static int furthestBuilding(int[] heights, int bricks, int ladders) {
        Map<Integer, Integer> jumps = new HashMap<>();
        
        for (int i = 0; i < heights.length - 1; i++) {
            if (heights[i] < heights[i + 1]) {
                jumps.put(i, heights[i + 1] - heights[i]);
            }
        }

        List<Map.Entry<Integer, Integer>> list = jumps.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .toList();

        int result = -1;
        int size = list.size();
        for (Map.Entry<Integer, Integer> entry : list) {
            if (bricks > 0 && bricks - entry.getValue() >= 0) {
                bricks -= entry.getValue();
                size--;
            } else if (ladders > 0) {
                ladders--;
                size--;
            } else {
                result = entry.getKey();
            }
        }
        
        return size == 0 ? heights.length - 1 : result;
    }

    public static void main(String[] args) {
        System.out.println(furthestBuilding(new int[]{4,2,7,6,9,14,12}, 5, 1));
    }
}
