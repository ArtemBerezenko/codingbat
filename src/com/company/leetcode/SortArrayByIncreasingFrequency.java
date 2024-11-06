package com.company.leetcode;

import java.util.*;

public class SortArrayByIncreasingFrequency {
    public static int[] frequencySort(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for (Integer num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        List<Integer> list = new ArrayList<>(Arrays.stream(nums).boxed().toList());
        Collections.sort(list, (o1, o2) -> {
            if (map.get(o2).equals(map.get(o1))) {
                return o2 - o1;
            }

            if (map.get(o2) < map.get(o1)) {
                return 1;
            } else {
                return -1;
            }

        });

        return list.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {
        System.out.println(frequencySort(new int[]{1,1,2,2,2,3}));
    }
}
