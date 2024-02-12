package com.company.leetcode;

import java.util.HashMap;
import java.util.Map;

public class MajorityElementII {

    public static int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            map.computeIfPresent(nums[i], (k, v) -> v + 1);
            map.putIfAbsent(nums[i], 1);
        }
        
        return map.entrySet().stream()
                .sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed())
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(-1);
    }

    public static void main(String[] args) {
        System.out.println(majorityElement(new int[] {2,2,1,1,1,2,2}));
    }
}
