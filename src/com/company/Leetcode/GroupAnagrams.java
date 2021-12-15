package com.company.Leetcode;

import java.util.*;

public class GroupAnagrams {

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (int i = 0; i < strs.length; i++) {
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            map.computeIfAbsent(String.valueOf(chars), k -> new ArrayList<>()).add(strs[i]);
        }
        return new ArrayList<>(map.values());
    }


    public static void main(String[] args) {
        System.out.println(groupAnagrams(new String[] {"eat","tea","tan","ate","nat","bat"}));
    }

}
