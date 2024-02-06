package com.company.leetcode;

import java.util.*;

public class GroupAnagramsII {
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        
        for (String str : strs) {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            map.computeIfAbsent(String.valueOf(charArray), k -> new ArrayList<>()).add(str);
        }

        return map.values().stream().toList();
    }

    public static void main(String[] args) {
        System.out.println(groupAnagrams(new String[] {"eat","tea","tan","ate","nat","bat"}));
    }
}
