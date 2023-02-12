package com.company.leetcode;

import java.util.Arrays;
import java.util.stream.Collectors;

public class CheckIfTwoStringArraysAreEquivalent {
    public static boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        String str1 = Arrays.stream(word1).map(String::valueOf).collect(Collectors.joining());
        String str2 = Arrays.stream(word2).map(String::valueOf).collect(Collectors.joining());

        return str1.equals(str2);
    }

    public static void main(String[] args) {
        System.out.println(arrayStringsAreEqual(new String[]{"ab", "c"}, new String[]{"a", "bc"}));
    }
}
