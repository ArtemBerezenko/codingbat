package com.company.leetcode;

import java.util.*;

public class SortTheJumbledNumbers {

    public static int[] sortJumbled(int[] mapping, int[] nums) {
        List<int[]> list = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            String number = Integer.toString(nums[i]);
            var n = new StringBuilder();

            for (int j = 0; j < number.length(); j++) {
                n.append(mapping[number.charAt(j) - '0']);
            }
            list.add(new int[] {Integer.parseInt(n.toString()), i});
        }

        list.sort(Comparator.comparing(o -> o[0]));

        int[] answer = new int[nums.length];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = nums[list.get(i)[1]];
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(sortJumbled(new int[] {8,9,4,0,2,1,3,5,7,6}, new int[] {991,338,38}));
    }
}
