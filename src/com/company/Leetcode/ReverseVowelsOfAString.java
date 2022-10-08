package com.company.Leetcode;

import java.util.*;

public class ReverseVowelsOfAString {

    public static String reverseVowels(String s) {
        Set<String> vowelsSet = new HashSet<>(List.of("a", "e", "i", "o", "u", "A", "E", "I", "O", "U"));
        List<String> existedVowels = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            String str = String.valueOf(s.charAt(i));
            if (vowelsSet.contains(str)) {
                existedVowels.add(str);
            }
        }

        Collections.reverse(existedVowels);
        int count = 0;

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            String str = String.valueOf(s.charAt(i));
            if (vowelsSet.contains(str)) {
                result.append(existedVowels.get(count++));
            } else {
                result.append(str);
            }
        }

        return result.toString();
    }

    public static String reverseVowelsTwoPointers(String s) {
        Set<Character> vowels = new HashSet<>(List.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
        char[] str = s.toCharArray();
        int l = 0;
        int h = str.length - 1;

        while (l < h) {
            while (l < s.length() && !vowels.contains(str[l])) {
                l++;
            }

            while (h >= 0 && !vowels.contains(str[h])) {
                h--;
            }

            if (l < h) {
                char tmp = str[l];
                str[l] = str[h];
                str[h] = tmp;
                l++;
                h--;
            }
        }
        return new String(str);
    }

    public static void main(String[] args) {
        System.out.println(reverseVowelsTwoPointers("leetcode"));
    }
}
