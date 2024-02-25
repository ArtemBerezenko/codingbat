package com.company.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class FurthestBuildingYouCanReach {

    public static int furthestBuilding(int[] heights, int bricks, int ladders) {
        Queue<Integer> ladderAllocations = new PriorityQueue<>(Comparator.comparingInt(a -> a));
        for (int i = 0; i < heights.length - 1; i++) {
            int climb = heights[i + 1] - heights[i];

            if (climb <= 0) {
                continue;
            }

            ladderAllocations.add(climb);

            if (ladderAllocations.size() <= ladders) {
                continue;
            }

            bricks -= ladderAllocations.remove();

            if (bricks < 0) {
                return i;
            }
        }
        return heights.length - 1;
    }

    public static void main(String[] args) {
        System.out.println(furthestBuilding(new int[]{4,2,7,6,9,14,12}, 5, 1));
    }
}
