package com.company.leetcode;

import java.util.HashMap;
import java.util.Map;

public class RedistributeCharactersToMakeAllStringsEqual {
    public static boolean makeEqual(String[] words) {
        Map<Character, Integer> map = new HashMap<>();
        
        for (String str : words) {
            for (int i = 0; i < str.length(); i++) {
                map.computeIfPresent(str.charAt(i), (k, v) -> v + 1);
                map.putIfAbsent(str.charAt(i), 1);
            }
        }
        
        for (int i : map.values()) {
            if (i % words.length != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(makeEqual(new String[] {"ab","a"}));
    }
}
