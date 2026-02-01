package com.company.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class DivideAnArrayIntoSubarraysWithMinimumCostI {
    public static int minimumCost(int[] nums) {
        List<Integer> list = new ArrayList<>(Arrays.stream(nums).boxed().toList());
        list.removeFirst();

        Collections.sort(list);

        return nums[0] + list.getFirst() + list.get(1);
    }

    public static void main(String[] args) {
        System.out.println(minimumCost(new int[]{10,3,1,1}));
    }
}
