package com.company.leetcode;

public class MinimumLengthOfStringAfterDeletingSimilarEnds {

    public static int minimumLength(String s) {
        int l = 0;
        int h = s.length() - 1;

        while (l < h && s.charAt(l) == s.charAt(h)) {
            if (s.charAt(l + 1) == s.charAt(h) && l + 1 != h) {
                l++;
            } else if (s.charAt(l) == s.charAt(h - 1) && l != h - 1) {
                h--;
            } else {
                l++;
                h--;
            }
        }

        return h - l + 1;
    }

    public int minimumLengthSOLUTION(String s) {
        int begin = 0;
        int end = s.length() - 1;

        // Delete similar ends until the ends differ or they meet in the middle
        while (begin < end && s.charAt(begin) == s.charAt(end)) {
            char c = s.charAt(begin);

            // Delete consecutive occurrences of c from prefix
            while (begin <= end && s.charAt(begin) == c) {
                begin++;
            }

            // Delete consecutive occurrences of c from suffix
            while (end > begin && s.charAt(end) == c) {
                end--;
            }
        }

        // Return the number of remaining characters
        return end - begin + 1;
    }

    public static void main(String[] args) {
        System.out.println(minimumLength("bbbbbbbbbbbbbbbbbbbbbbbbbbbabbbbbbbbbbbbbbbccbcbcbccbbabbb"));
    }
}
