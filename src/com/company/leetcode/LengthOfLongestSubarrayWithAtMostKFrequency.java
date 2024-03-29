package com.company.leetcode;

import java.util.*;

public class LengthOfLongestSubarrayWithAtMostKFrequency {
    public static int maxSubarrayLength(int[] nums, int k) {
        List<List<Integer>> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        
        LinkedList<Integer> currentList = new LinkedList<>();
        for (int r = 0; r < nums.length; r++) {

            int i = map.getOrDefault(nums[r], 0);
            if (i < k) {
                currentList.add(nums[r]);
            } else {
                list.add(currentList);
                currentList = new LinkedList<>(currentList);
                currentList.add(nums[r]);
                while (map.get(nums[r]) >= k && !currentList.isEmpty()) {
                    Integer first = currentList.getFirst();
                    currentList.removeFirst();
                    map.computeIfPresent(first, (key, v) -> v - 1);
                }
            }
            map.computeIfPresent(nums[r], (key, v) -> v + 1);
            map.putIfAbsent(nums[r], 1);
        }
        
        list.add(currentList);
        
        return list.stream()
                .map(List::size)
                .max(Integer::compareTo)
                .orElse(0);
    }

    public static int maxSubarrayLengthSOLUTION(int[] nums, int k) {
        int count = 0;
        int l = -1;
        
        Map<Integer, Integer> map = new HashMap<>();

        for (int r = 0; r < nums.length; r++) {
            map.put(nums[r], map.getOrDefault(nums[r], 0) + 1);
            while (map.get(nums[r]) > k) {
                l++;
                map.put(nums[l], map.get(nums[l]) - 1);
            }
            count = Math.max(count, r - l);
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(maxSubarrayLengthSOLUTION(new int[]{1,2,2,1,3}, 1));
    }
}
