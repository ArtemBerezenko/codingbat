package com.company.Leetcode;

import java.util.ArrayList;
import java.util.List;

public class LongestSubstringWithoutRepeatingCharacters {

    public static int lengthOfLongestSubstring(String s) {
        List<String> list = new ArrayList<>();
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                String str = s.substring(j, j + 1);
                if (!list.contains(str)) {
                    list.add(str);
                } else {
                    break;
                }
            }
            int current = list.size();
            if (current > max) {
                max = current;
            }
            list.clear();
        }
        return max;
    }

    public static void main(String[] args) {
        int result = lengthOfLongestSubstring("pwwkew");
    }
}
