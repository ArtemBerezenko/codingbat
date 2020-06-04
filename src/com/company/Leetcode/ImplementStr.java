package com.company.Leetcode;

public class ImplementStr {
    public static int strStr(String haystack, String needle) {
        if (needle.isEmpty()) return 0;
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            String current = haystack.substring(i, i + needle.length());
            if (current.equals(needle)) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(strStr("a", "a"));
        System.out.println(strStr("hello", "ll"));
    }

}
