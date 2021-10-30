package com.company.Leetcode;

public class ReverseWordsInStringIII {

    public static String reverseWords(String s) {
        char[] cs = s.toCharArray();
        int l = 0;

        for (int i = 0; i < cs.length; i++) {
            if (cs[i] == ' ' || i == cs.length - 1) {
                int h = i == cs.length - 1 ? i : i - 1;
                while (l < h) {
                    char temp = cs[h];
                    cs[h] = cs[l];
                    cs[l] = temp;
                    l++;
                    h--;
                }
                l = i + 1;
            }
        }

        return String.valueOf(cs);
    }

    public static void main(String[] args) {
        System.out.println(reverseWords("Let's take LeetCode contest"));
    }
}