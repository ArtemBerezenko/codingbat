package com.company.leetcode;

import java.util.TreeMap;

public class DeleteAndEarn {


    public static int deleteAndEarn(int[] nums) {
        TreeMap<Integer, Integer> map = new TreeMap<>();

        for (Integer i : nums) {
            map.computeIfPresent(i, (k, v) -> v + 1);
            map.putIfAbsent(i, 1);
        }

        var prevIncEarn = 0;
        var prevExcEarn = 0;
        for (var i = map.firstKey(); i <=  map.lastKey(); i++) {
            var incEarn = prevExcEarn + i * map.getOrDefault(i, 0);
            var excEarn = Math.max(prevIncEarn, prevExcEarn);
            prevIncEarn = incEarn;
            prevExcEarn = excEarn;
        }
        return Math.max(prevIncEarn, prevExcEarn);

    }

    public static void main(String[] args) {
        System.out.println(deleteAndEarn(new int[]{3,1}));
    }

}
