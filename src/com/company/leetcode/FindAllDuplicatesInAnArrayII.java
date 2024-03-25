package com.company.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindAllDuplicatesInAnArrayII {
    public static List<Integer> findDuplicates(int[] nums) {
        Set<Integer> set = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        
        for (Integer i : nums) {
            if (set.contains(i)) {
                list.add(i);
            }
            set.add(i);
        }
        
        return list;
    }

    public static void main(String[] args) {
        System.out.println(findDuplicates(new int[] {4,3,2,7,8,2,3,1}));
    }
}
