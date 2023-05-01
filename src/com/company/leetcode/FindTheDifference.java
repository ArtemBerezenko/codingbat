package com.company.leetcode;

import java.util.HashMap;
import java.util.Map;

public class FindTheDifference {

    public static char findTheDifference(String s, String t) {
        Map<Character, Integer> map1 = createMap(s);
        Map<Character, Integer> map2 = createMap(t);

        for (Map.Entry<Character, Integer> entry : map2.entrySet()) {
            Integer value = map1.get(entry.getKey());
            if (!entry.getValue().equals(value)) {
                return entry.getKey();
            }
        }

        return ' ';
    }

    private static Map<Character, Integer> createMap(String string) {
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < string.length(); i++) {
            Character key = string.charAt(i);
            map.computeIfPresent(key, (k, v) -> v + 1);
            map.putIfAbsent(key, 1);
        }
        return map;
    }

    public static void main(String[] args) {
        System.out.println(findTheDifference("abcd", "abcde"));
    }
}
