package com.company.Leetcode;

public class LongestPalindromicSubstring {

    public static String longestPalindromeLongWrongWay(String s) {
        String current = "";
        String result = "";
        for (int i = 0; i < s.length(); i++) {
            for (int k = s.length() - 1; k > i; k--) {
                if (s.substring(k, k + 1).equals(s.substring(i, i + 1))) {
                    int length = s.substring(i, k + 1).length();
                    int mid = length / 2;
                    StringBuilder sb;
                    if (length % 2 == 0) {
                        sb = new StringBuilder(s.substring(mid + i, k + 1));
                    } else {
                        sb = new StringBuilder(s.substring(mid + i + 1, k + 1));
                    }
                    String compareStr = sb.reverse().toString();
                    if (s.substring(i, i + mid).equals(compareStr)) {
                        current = s.substring(i, k + 1);
                    }
                    if (current.length() > result.length()) {
                        result = current;
                        break;
                    }
                } else {
                    current = "";
                }
            }
        }
        if (result.isEmpty() && !s.isEmpty()) {
            return s.substring(0, 1);
        }
        return result;
    }

    public static String longestPalindromeWithTwoLoops(String s) {
        String current = "";
        String result = "";
        for (int i = 0; i < s.length(); i++) {
            for (int k = s.length() - 1; k > i; k--) {
                String str = s.substring(i, k + 1);
                StringBuilder sb = new StringBuilder(str);
                String reverse = sb.reverse().toString();
                if (str.equals(reverse)) {
                    current = str;
                }
                if (current.length() > result.length()) {
                    result = current;
                }
            }
        }
        if (result.isEmpty() && !s.isEmpty()) {
            return s.substring(0, 1);
        }
        return result;
    }

    public static String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int length1 = expandAroundCenter(s, i, i);
            int length2 = expandAroundCenter(s, i, i + 1);
            int length = Math.max(length1, length2);
            if (length > end - start) {
                start = i - (length - 1) / 2;
                end = i + length / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private static int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }

    public static void main(String[] args) {
//        System.out.println(longestPalindrome("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee"));
//        System.out.println(longestPalindrome("aaabaaaa"));
        System.out.println(longestPalindrome("babad"));
//        System.out.println(longestPalindrome("cbbc"));
//        System.out.println(longestPalindrome("cbbd"));
//        System.out.println(longestPalindrome("ccd"));
//        System.out.println(longestPalindrome("abcba"));
//        System.out.println(longestPalindrome("caba"));
//        System.out.println(longestPalindrome("aa"));
//        System.out.println(longestPalindrome("ac"));
//        System.out.println(longestPalindrome("a"));
//        System.out.println(longestPalindrome("abcda"));
//        System.out.println(longestPalindrome(""));
    }
//    "babad""cbbc" "cbbd" "ccd" "abcba" "caba" "ac" "abcda" "aaabaaaa"
    //"eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee"
}
