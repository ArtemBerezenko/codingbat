package com.company.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MeetingRooms {
    public static boolean canAttendMeetings(int[][] intervals) {
        List<Integer> list = Arrays.stream(intervals)
                .flatMapToInt(Arrays::stream)
                .boxed()
                .distinct()
                .sorted()
                .collect(Collectors.toList());

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < list.size(); i++) {
            map.put(list.get(i), i);
        }

        for (int i = 0; i < intervals.length; i++) {
            for (int j = 0; j < intervals[0].length - 1; j++) {
                int first = intervals[i][j];
                int second = intervals[i][j + 1];

               if (map.get(second) - map.get(first) > 1) {
                   return false;
               }
            }
        }
        return true;
    }

    public static boolean canAttendMeetingsSOLUTION(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        for (int i = 0; i < intervals.length - 1; i++) {
            if (intervals[i][1] > intervals[i + 1][0]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(canAttendMeetingsSOLUTION(new int[][]{{13,15},{1,13}}));
    }
}
