package com.company.leetcode;

import java.util.HashMap;
import java.util.Map;

public class RansomNote {
    public static boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> map1 = new HashMap<>();

        for (Character c : magazine.toCharArray()) {
            map1.put(c, map1.getOrDefault(c, 0) + 1);
        }

        Map<Character, Integer> map2 = new HashMap<>();

        for (Character c : ransomNote.toCharArray()) {
            map2.put(c, map2.getOrDefault(c, 0) + 1);
        }

        for (Map.Entry<Character, Integer> entry : map2.entrySet()) {
            if (!map1.containsKey(entry.getKey())) {
                return false;
            }
            if (map1.get(entry.getKey()).compareTo(entry.getValue()) < 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(canConstruct("bg", "efjbdfbdgfjhhaiigfhbaejahgfbbgbjagbddfgdiaigdadhcfcj"));
    }
}
