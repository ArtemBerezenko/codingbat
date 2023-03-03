package com.company.leetcode;

public class FindTheIndexOfTheFirstOccurrenceInAString {

    public static int strStr(String haystack, String needle) {
        int i = 0;

        while (i + needle.length() <= haystack.length()) {
            String str = haystack.substring(i, i + needle.length());
            if (str.equals(needle)) {
                return i;
            } else {
                i++;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(strStr("mississippi", "issi"));
    }
}
