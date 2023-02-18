package com.company.leetcode;

public class SplitAStringInBalancedStrings {
    public static int balancedStringSplit(String s) {
        int l = 0;
        int r = 0;

        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            String str = String.valueOf(s.charAt(i));
            if (str.equals("L")) {
                l++;
            } else {
                r++;
            }
            if (l == r) {
                result++;
                l = 0;
                r = 0;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(balancedStringSplit("LLLLRRRR"));
    }

}
