package com.company.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LongestUnequalAdjacentGroupsSubsequenceI {
    public static List<String> getLongestSubsequence(String[] words, int[] groups) {
        List<String> resultList = new ArrayList<>();

        for (int i = 0; i < groups.length; i++) {
            while (i == 0 || i < groups.length && groups[i] != groups[i - 1]) {
                resultList.add(words[i++]);
            }
        }
        return resultList;
    }

    public static void main(String[] args) {
        System.out.println(getLongestSubsequence(new String[]{"d","a","v","b"}, new int[]{1,0,0,1}));
    }
}
