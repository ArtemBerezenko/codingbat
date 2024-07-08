package com.company.leetcode;

import java.util.HashMap;
import java.util.Map;

public class RearrangeCharactersToMakeTargetString {

    public static int rearrangeCharacters(String s, String target) {
        Map<Character, Integer> map1 = new HashMap<>();

        for (Character c : target.toCharArray()) {
            map1.put(c, map1.getOrDefault(c, 0) + 1);
        }

        Map<Character, Integer> map2 = new HashMap<>();

        for (Character c : s.toCharArray()) {
            map2.put(c, map2.getOrDefault(c, 0) + 1);
        }

        int result = Integer.MAX_VALUE;
        for (Map.Entry<Character, Integer> entry : map1.entrySet()) {
            result = Math.min(result, map2.getOrDefault(entry.getKey(), 0) / entry.getValue());
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(rearrangeCharacters("ilovecodingonleetcode", "code"));
    }
}
