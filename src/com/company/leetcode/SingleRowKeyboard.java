package com.company.leetcode;

import java.util.HashMap;
import java.util.Map;

public class SingleRowKeyboard {
    public static int calculateTime(String keyboard, String word) {
        Map<Character, Integer> map = new HashMap<>();
        
        for (int i = 0; i < keyboard.length(); i++) {
            map.put(keyboard.charAt(i), i);
        }
        
        int result = 0;
        int previous = 0;
        for (Character c : word.toCharArray()) {
            result += Math.abs(map.get(c) - previous);
            previous = map.get(c);
        }
        return result;
    }


    public static void main(String[] args) {
        System.out.println(calculateTime("pqrstuvwxyzabcdefghijklmno", "leetcode"));

    }
}
