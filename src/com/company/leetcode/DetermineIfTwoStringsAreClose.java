package com.company.leetcode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DetermineIfTwoStringsAreClose {

    public static boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length()) {
            return false;
        }
        Map<Character, Integer> map1 = getMap(word1);
        Map<Character, Integer> map2 = getMap(word2);
        
        if (!map1.keySet().equals(map2.keySet())) {
            return false;
        }

        List<Integer> list1 = map1.values().stream().sorted().toList();
        List<Integer> list2 = map2.values().stream().sorted().toList();
        
        return list1.equals(list2);
    }

    private static Map<Character, Integer> getMap(String word1) {
        Map<Character, Integer> map = new HashMap<>();

        for (Character c: word1.toCharArray()) {
            map.computeIfPresent(c, (k, v) -> v + 1);
            map.putIfAbsent(c, 1);
        }
        
        return map;
    }

    public static void main(String[] args) {
        System.out.println(closeStrings( "abc", "bca"));
    }
}
