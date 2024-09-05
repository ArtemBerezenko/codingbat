package com.company.leetcode;

public class SumOfDigitsOfStringAfterConvert {
    public static int getLucky(String s, int k) {
        var sb = new StringBuilder();

        for (Character c : s.toCharArray()) {
            sb.append((c - 'a') + 1);
        }

        while (k > 0) {
            int result = 0;
            for (Character c : sb.toString().toCharArray()) {
                result += Integer.parseInt(String.valueOf(c));
            }
            sb = new StringBuilder(String.valueOf(result));
            k--;
        }

        return Integer.parseInt(sb.toString());
    }

    public static void main(String[] args) {
        System.out.println(getLucky("leetcode", 2));
    }
}
