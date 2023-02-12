package com.company.leetcode;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FirstMissingPositive {

    public static int firstMissingPositive(int[] nums) {
        List<Integer> list = Arrays.stream(nums).boxed().sorted().distinct().filter(n -> n > 0).collect(Collectors.toList());

        int num = 0;
        for (int i = 0; i < list.size(); i++) {
            num = i + 1;
            if (num != list.get(i)) {
                return num;
            }
        }
        return num + 1;
    }

    public static int firstMissingPositiveRight(int[] nums) {
        Arrays.sort(nums);
        int i = 1;

        for (int num : nums) {
            if (num == i) i++;
        }
        return i;
    }


    public static void main(String[] args) {
        System.out.println(firstMissingPositiveRight(new int[]{1, 2, 0, -1, -55, 2, 2, 2}));
    }
}
