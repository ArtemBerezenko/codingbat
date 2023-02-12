package com.company.leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class FindClosestNumberToZero {

    public static int findClosestNumber(int[] nums) {
        List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());
        list.add(0);
        Collections.sort(list);

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == 0) {
                if (i == 0) {
                    return list.get(i + 1);
                } else if (i == list.size() - 1) {
                    return list.get(i - 1);
                } else {
                    if (Math.abs(list.get(i - 1)) == Math.abs(list.get(i + 1))) {
                        return Math.max(list.get(i - 1), list.get(i + 1));
                    }
                    return Math.abs(list.get(i - 1)) > Math.abs(list.get(i + 1)) ? list.get(i + 1) : list.get(i - 1);
                }
            }
        }
        return -1;
    }

    public static int findClosestNumberSOLUTION(int[] nums) {
        int distance;
        int max = Integer.MAX_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            distance = Math.abs(nums[i]);
            if (distance < max) {
                max = distance;
                min = nums[i];
            }

            if (distance == max) {
                max = distance;
                min = Math.max(nums[i], min);
            }

        }
        return min;
    }

    public static void main(String[] args) {
        System.out.println(findClosestNumberSOLUTION(new int[] {-4,-2,1,4,8}));
    }
}
