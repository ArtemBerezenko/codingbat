package com.company.leetcode;

public class FindFirstPalindromicStringInArray {
    public static String firstPalindrome(String[] words) {
        for (String str : words) {
            if (str.contentEquals(new StringBuilder(str).reverse())) {
                return str;
            }
        }
        return "";
    }

    public static void main(String[] args) {
        System.out.println(firstPalindrome(new String[] {"abc","car","ada","racecar","cool"}));
    }
}
