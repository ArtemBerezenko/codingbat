package com.company.leetcode;

import java.util.HashMap;
import java.util.Map;

public class ContiguousArray {
    public static int findMaxLength(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int max = 0;
        int count = 0;
        
        for (int i = 0; i < nums.length; i++) {
            count = count + (nums[i] == 1 ? 1 : -1);
            if (map.containsKey(count)) {
                max = Math.max(max, i - map.get(count));
            } else {
                map.put(count, i);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(findMaxLength(new int[]{0,0,0,1,1,0,1,1,1,1,0,0,0,0}));
    }

}
