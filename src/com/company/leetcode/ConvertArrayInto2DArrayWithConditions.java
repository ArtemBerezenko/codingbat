package com.company.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConvertArrayInto2DArrayWithConditions {
    public static List<List<Integer>> findMatrix(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            map.computeIfPresent(nums[i], (k, v) -> v + 1);
            map.putIfAbsent(nums[i], 1);
        }
        
        Map<Integer, Integer> dummy = new HashMap<>(map);
        List<List<Integer>> resultList = new ArrayList<>();
        
        while (!map.entrySet().isEmpty()) {
            List<Integer> list = new ArrayList<>();
            for (Map.Entry<Integer, Integer> entry : dummy.entrySet()) {
                map.computeIfPresent(entry.getKey(), (k, v) -> {
                    list.add(entry.getKey());
                    v -= 1;
                    return v;
                });
                if (map.containsKey(entry.getKey()) && map.get(entry.getKey()) == 0) {
                    map.remove(entry.getKey());
                }
            }
            resultList.add(list);
        }
        return resultList;
    }

    public static void main(String[] args) {
        System.out.println(findMatrix(new int[] {1,2,3,4}));
    }
}
