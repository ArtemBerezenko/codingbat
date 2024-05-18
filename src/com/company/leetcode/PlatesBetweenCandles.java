package com.company.leetcode;

import java.util.Arrays;

public class PlatesBetweenCandles {

    public static int[] platesBetweenCandles(String s, int[][] queries) {
        int[] res = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            res[i] = findLength(s, queries[i]);
        }
        return res;
    }

    private static int findLength(String s, int[] arr) {
        s = s.substring(arr[0], arr[1] + 1);
        int l = 0;
        int r = s.length() - 1;

        int count = 0;
        boolean left = false;
        boolean right = false;
        while (l < r) {
            if (s.charAt(l) == '|') {
                left = true;
            } else {
                l++;
            }
            if (s.charAt(r) == '|') {
                right = true;
            } else {
                r--;
            }

            if (left && right) {
                count++;
                l++;
                r--;
            }
        }

        return count + (s.length() % 2 == 0 ? 0 : 1);
    }

    public static int[] platesBetweenCandlesSOLUTION(String s, int[][] queries) {
        int psum[] = new int[s.length() + 1];
        int next[] = new int[s.length() + 1];
        int prev[] = new int[s.length() + 1];

        Arrays.fill(next, Integer.MAX_VALUE);

        int res[] = new int[queries.length];

        for (int i = 0; i < s.length(); ++i) {
            psum[i + 1] = psum[i] + (s.charAt(i) == '|' ? 1 : 0);
            prev[i + 1] = s.charAt(i) == '|' ? i : prev[i];
        }

        for (int i = s.length() - 1; i >= 0; --i) {
            next[i] = s.charAt(i) == '|' ? i : next[i + 1];
        }
        for (int j = 0; j < queries.length; ++j) {
            int l = next[queries[j][0]], r = prev[queries[j][1] + 1];
            res[j] = l < r ? r - l - (psum[r] - psum[l]) : 0;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(platesBetweenCandles("**|**|***|",
                new int[][]{{2,5},{5,9}}));
    }
}
