package com.company.leetcode;

import java.util.HashMap;
import java.util.Map;

public class SetMismatch {
    public static int[] findErrorNums(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            map.computeIfPresent(nums[i], (k, v) -> v + 1);
            map.putIfAbsent(nums[i], 1);
        }
        
        int[] result = new int[] {-1, 1};
        for (int i = 1; i <= nums.length; i++) {
            if (map.containsKey(i)) {
                if (map.get(i) == 2) {
                    result[0] = i;
                }
            } else {
                result[1] = i;
            }
        }
        
        
        return result;
    }

    public static void main(String[] args) {
        System.out.println(findErrorNums(new int[] { 1,2,2,4 }));
    }
    
}
