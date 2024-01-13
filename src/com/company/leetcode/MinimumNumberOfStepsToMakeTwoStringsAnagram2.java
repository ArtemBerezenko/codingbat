package com.company.leetcode;

import java.util.HashMap;
import java.util.Map;

public class MinimumNumberOfStepsToMakeTwoStringsAnagram2 {

    public static int minSteps(String s, String t) {
        Map<Character, Integer> mapS = getMap(s);
        Map<Character, Integer> mapT = getMap(t);

        for (Map.Entry<Character, Integer> entry : mapT.entrySet()) {
            mapS.computeIfPresent(entry.getKey(), (k, v) -> v > entry.getValue() ? v - entry.getValue() : 0);

        }
        return mapS.values().stream().mapToInt(Integer::intValue).sum();
    }

    private static Map<Character, Integer> getMap(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (Character c : s.toCharArray()) {
            map.computeIfPresent(c, (k, v) -> v + 1);
            map.putIfAbsent(c, 1);
        }
        return map;
    }


    public static void main(String[] args) {
        System.out.println(minSteps( "bab", "aba"));
    }
}
