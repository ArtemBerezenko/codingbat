package com.company.leetcode;

import java.util.Arrays;

public class ValidAnagramII {
    public static boolean isAnagram(String s, String t) {
        char[] aArray = s.toCharArray();
        char[] tArray = t.toCharArray();

        Arrays.sort(aArray);
        Arrays.sort(tArray);

        return String.valueOf(aArray).equals(String.valueOf(tArray));
    }

    public static void main(String[] args) {
        System.out.println(isAnagram("anagram", "nagaram"));
    }
}
