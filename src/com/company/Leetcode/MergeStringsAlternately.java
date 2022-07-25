package com.company.Leetcode;

public class MergeStringsAlternately {
    public static String mergeAlternately(String word1, String word2) {
        char[] chars1 = word1.toCharArray();
        char[] chars2 = word2.toCharArray();
        char[] result = new char[chars1.length + chars2.length];

        int l = 0;
        int h = Math.max(chars1.length, chars2.length);

        int i = 0;
        while (l < h) {
            if (l < chars1.length) {
                result[i++] = chars1[l];
            }
            if (l < chars2.length) {
                result[i++] = chars2[l];
            }
            l++;
        }
        return String.valueOf(result);
    }

    public static void main(String[] args) {
        System.out.println(mergeAlternately("abc", "pqr"));
    }
}
