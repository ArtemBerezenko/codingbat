package com.company.leetcode;

public class MaximumScoreAfterSplittingString {

    public static int maxScore(String s) {
        int zeros = 0;
        int ones = 0;
        int sum = 0;
        for (Character c : s.toCharArray()) {
            int i = Integer.parseInt(String.valueOf(c));
            if (i == 1) {
                ones++;
            }
        }
        
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == '0') {
                zeros++;
            } else {
                ones--;
            }
            sum = Math.max(sum, zeros + ones);
        }
        return sum;
    }
    
    public static void main(String[] args) {
        System.out.println(maxScore("00"));
    }
}
