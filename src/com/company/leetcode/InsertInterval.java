package com.company.leetcode;

import java.util.ArrayList;
import java.util.List;

public class InsertInterval {
    public static int[][] insert(int[][] intervals, int[] newInterval) {
        int start = newInterval[0];
        int end = newInterval[1];
        List<int[]> result = new ArrayList<>();
        
        int i = 0;
        while (i < intervals.length && start > intervals[i][1]){
            result.add(intervals[i]);
            i++;
        }
        while (i < intervals.length && end >= intervals[i][0]) {
            start =  Math.min(start, intervals[i][0]);
            end = Math.max(end, intervals[i][1]);
            i++;
        }
        result.add(new int[] {start, end});

        while (i < intervals.length) {
            result.add(intervals[i]);
            i++;
        }
        
        return result.toArray(int[][]::new);
    }

    public static void main(String[] args) {
        System.out.println(insert(new int[][]{{1,3}, {6,9}}, new int[] {2,5}));
    }
}
