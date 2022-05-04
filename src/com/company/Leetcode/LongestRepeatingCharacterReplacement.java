package com.company.Leetcode;

import java.util.HashMap;
import java.util.Map;

public class LongestRepeatingCharacterReplacement {


    public static int characterReplacementWrong(String s, int k) {
        int maxCount = 0;
        int curCount = 1;
        int n = k;

        int i = 0;

        while (i < s.length() - 1) {
            String first = s.substring(i, i + 1);

            int j = i + 1;
            while (j < s.length() && (s.substring(j, j + 1).equals(first) || n > 0)) {
                if (!s.substring(j, j + 1).equals(first)) {
                    n--;
                }
                j++;
                curCount++;
            }

            while (n > 0 && s.length() - curCount > 0) {
                curCount++;
            }

            if (curCount > maxCount) {
                maxCount = curCount;
            }

            i = k == 0 ? j : j - 1;
            n = k;
            curCount = 1;
        }


        return maxCount;
    }

    public static int characterReplacement(String s, int k) {
        int left = 0;
        int max = 0;
        int maxRepeatChar = 0;

        Map<Character, Integer> freqMap = new HashMap<>();

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
            maxRepeatChar = Math.max(maxRepeatChar, freqMap.get(c));

            if (right - left + 1 - maxRepeatChar > k) {
                char leftChar = s.charAt(left);
                freqMap.put(leftChar, freqMap.get(leftChar) - 1);
                left++;
            }

            max = Math.max(max, right - left + 1);
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println(characterReplacement("AABABBA", 1));
    }
}
