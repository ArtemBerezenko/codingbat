package com.company.Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LongestCommonPrefix {
    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        String prefix = "";
        int i = 1;
        List<String> list = new ArrayList<>();
        while (list.size() <= 1 && i <= strs[0].length()) {
            int index = i;
            list = Arrays
                    .stream(strs)
                    .map(s -> {
                                if (!s.isEmpty() && s.length() >= index) {
                                    return s.substring(0, index);
                                }
                                return s;
                            }
                    )
                    .distinct()
                    .collect(Collectors.toList());
            if (list.size() == 1) prefix = list.get(0);
            i++;
        }
        return prefix;
    }

    public static String longestCommonPrefixBinarySearch(String[] strs) {
        if (strs.length == 0) return "";
        int low = 1;
        int high = Integer.MAX_VALUE;
        for (String s : strs) {
            high = Math.min(s.length(), high);
        }
        while (low <= high) {
            int mid = (low + high) / 2;
            if (isCommonPrefix(strs, mid)) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return strs[0].substring(0, (low + high) / 2);
    }



    private static boolean isCommonPrefix(String[] strs, int len){
        String prefix = strs[0].substring(0, len);
        for (String s : strs) {
            if (!s.substring(0, len).equals(prefix)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
//        System.out.println(longestCommonPrefix(new String[]{""}));
        System.out.println(longestCommonPrefixBinarySearch(new String[]{"flower","flow","flight"}));
    }
}
