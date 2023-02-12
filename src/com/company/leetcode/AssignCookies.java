package com.company.leetcode;

import java.util.Arrays;

public class AssignCookies {
    public static int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int i = 0;
        int l = 0;

        while (l < s.length && i < g.length) {
            if (s[l] >= g[i]) {
                i++;
            }
            l++;
        }
        return i;
    }

    public static void main(String[] args) {
        System.out.println(findContentChildren(new int[]{1,2}, new int[]{1,2,3}));
    }
}
