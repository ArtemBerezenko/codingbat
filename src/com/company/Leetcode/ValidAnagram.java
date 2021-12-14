package com.company.Leetcode;

import java.util.Arrays;

public class ValidAnagram {

    public static boolean isAnagram(String s, String t) {
        char[] charsS = s.toCharArray();
        char[] charsT = t.toCharArray();

        Arrays.sort(charsS);
        Arrays.sort(charsT);

        return Arrays.equals(charsS, charsT);
    }

    public static void main(String[] args) {
        System.out.println(isAnagram("aa", "a"));
    }
}
