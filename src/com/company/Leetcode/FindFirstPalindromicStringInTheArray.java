package com.company.Leetcode;

public class FindFirstPalindromicStringInTheArray {

    public static String firstPalindrome(String[] words) {
        for (int i = 0; i < words.length; i++) {
            if (checkIfPalindrome(words[i])) {
                return words[i];
            }
        }
        return "";
    }

    private static boolean checkIfPalindrome(String str) {
        int l = 0;
        int h = str.length() - 1;

        while (l < h) {
            if (str.charAt(l) != str.charAt(h)) {
                return false;
            }
            l++;
            h--;
        }
        return true;
    }

    public static void main(String[] args) {
//        System.out.println(firstPalindrome(new String[]{"abc","car","ada","racecar","cool"}));
//        System.out.println(firstPalindrome(new String[]{"notapalindrome","racecar"}));
        System.out.println(firstPalindrome(new String[]{"def","ghi"}));
    }
}
